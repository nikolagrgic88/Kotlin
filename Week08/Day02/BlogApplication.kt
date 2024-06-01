package com.example.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*;
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException


data class StudentResults(
    val studentId: Int,
    val subjectId: Int,
    val session: Int,
    val mark: String,

    );


@RestController
@RequestMapping("/api/enrol")
class EnrolmentController {

    @GetMapping("/getInfo/{id}")
    fun getInfo(@PathVariable id: Int): String {

        val sqlURL = "jdbc:postgresql://leftshift.xyz:5433/university"
        val connection = DriverManager
            .getConnection(sqlURL, "postgres", "nikola9876");
        val query = connection.prepareStatement("SELECT * FROM student WHERE student_id = ?")
        query.setInt(1, id)

        val result = query.executeQuery()

        if (!result.next()) {
            return "No student found with the provided ID."
        }

        val studentId = result.getInt("student_id")
        val fullName = result.getString("name")
        val spl = fullName.split(" ")
        val first = spl[0]
        val last = spl[1]
        val studentAge = result.getInt("age")
        val enrolmentStatus = result.getString("enrolment_status")

        return """
        <!DOCTYPE html>
        <html lang="en">
        <head>
             <meta charset="UTF-8">
             <meta name="viewport" content="width=device-width, initial-scale=1.0">          
        </head>
        <body>
                       <h1>Info Page</h1>
            <p>Student ID: $studentId</p>
            <p>First Name: $first</p>
            <p>Last Name: $last</p>
            <p>Age: $studentAge</p>
            <p>Enrolled: $enrolmentStatus</p>
            <button><a href='/api/enrol/unenroll/$id'>Delete Student</a></button>

        </body>
        </html>
        """
    }

    @PostMapping("/submit")
    fun submit(
        @RequestParam firstName: String,
        @RequestParam lastName: String,
        @RequestParam age: Int,
        @RequestParam enrolment: String
    ): String {
        try {
            val sqlURL = "jdbc:postgresql://leftshift.xyz:5433/university"
            val connection = DriverManager.getConnection(sqlURL, "postgres", "nikola9876")

            val insertNewData =
                "INSERT INTO student (name, enrolment_status, age, current_student) VALUES (?, ?, ?, ?)"
            val statement: PreparedStatement = connection.prepareStatement(insertNewData)

            // Setting values for parameters
            statement.setString(1, "$firstName $lastName")
            statement.setString(2, enrolment)
            statement.setInt(3, age)
            statement.setBoolean(4, true)

            val rowsAffected = statement.executeUpdate()
            println("$rowsAffected row(s) inserted")

            statement.close()
            connection.close()

        } catch (e: Exception) {
            e.printStackTrace()
            println("Error inserting data: ${e.message}")

        }
        return """
        <!DOCTYPE html>
        <html lang="en">
        <head>
             <meta charset="UTF-8">
             <meta name="viewport" content="width=device-width, initial-scale=1.0">
             <title>Student Enrollment</title>
        </head>
        <body>
             <h1>Welcome, ${firstName}!</h1>
             <p>Congratulations on enrolling with University ❤️</p>
             
        </body>
        </html>
        """
    }

    @GetMapping("/unenroll/{id}")
    fun unenroll(@PathVariable id: String): String {
        try {
            val studentId = id.toIntOrNull() ?: return "<h1>Invalid student ID: $id</h1>"

            val sqlURL = "jdbc:postgresql://leftshift.xyz:5433/university"
            val connection = DriverManager.getConnection(sqlURL, "postgres", "nikola9876")

            val deleteData =
                "DELETE FROM student WHERE student_id = ?"
            val statement: PreparedStatement = connection.prepareStatement(deleteData)

            statement.setInt(1, studentId)

            val rowsAffected = statement.executeUpdate()
            statement.close()
            connection.close()

            if (rowsAffected > 0) {
                return """
             <!DOCTYPE html>
             <html lang="en">
             <head>
             <meta charset="UTF-8">
             <meta name="viewport" content="width=device-width, initial-scale=1.0">
             <title>Student Enrollment</title>
             </head>
                <body>
        
                    <h1>Student with ID $id has been deleted.</h1>             
             </body>
             </html>
            """
            } else {
                return "<h1>Student with id: $id want found</h1>"

            }

        } catch (e: Exception) {
            e.printStackTrace()
            println("Error deleting data: ${e.message}")
            return "An error occurred while deleting the student."
        }

    }

}

@RestController
@RequestMapping("/api/marks")
class SubjectResultController {

    @PostMapping("/create")
    fun createMark(
        @RequestParam studentId: Int,
        @RequestParam subjectId: Int,
//        @RequestParam sessionId: Int,
        @RequestParam mark: String
    ): String {
        try {
            val sqlURL = "jdbc:postgresql://leftshift.xyz:5433/university"
            val connection = DriverManager.getConnection(sqlURL, "postgres", "nikola9876")

            val checkQuery = "SELECT * FROM subject_results WHERE student_Id = ? AND subject_id = ?"
            val statement: PreparedStatement = connection.prepareStatement(checkQuery)
            statement.setInt(1, studentId)
            statement.setInt(2, subjectId)


            val result = statement.executeQuery()
            if (result.next()) {
                //updating marks
                val updateQuery =
                    "UPDATE subject_results SET marks = ? WHERE student_id = ? AND subject_id = ? "
                val updateStatement: PreparedStatement = connection.prepareStatement(updateQuery)
                updateStatement.setString(1, mark)
                updateStatement.setInt(2, studentId)
                updateStatement.setInt(3, subjectId)

                updateStatement.executeUpdate()
                updateStatement.close()
                return "Mark updated successfully."

            } else {

                val insertQuery = "INSERT INTO subject_results (student_id,subject_id,marks) VALUES(?,?,?) "
                val insertStatement: PreparedStatement = connection.prepareStatement(insertQuery)
                insertStatement.setInt(1, studentId)
                insertStatement.setInt(2, subjectId)
//                insertStatement.setInt(3, sessionId)
                insertStatement.setString(3, mark)
                insertStatement.executeUpdate()
                insertStatement.close()
                return "Mark inserted successfully."
            }

        } catch (e: SQLException) {
            e.printStackTrace()
            return "Error: " + e.message
        }
    }


    @GetMapping("/getResults")
    fun getResults(
        @RequestParam subjectId: Int,
        @RequestParam startId: Int,
        @RequestParam endId: Int
    ): String {
        val results: MutableList<StudentResults> = mutableListOf()

        try {
            val sqlURL = "jdbc:postgresql://leftshift.xyz:5433/university"
            val connection = DriverManager.getConnection(sqlURL, "postgres", "nikola9876")

            val limit = endId - startId + 1
            val retrieveQuery = """
                SELECT * FROM subject_results
                WHERE subject_id = ? AND student_id >= ? AND student_id <= ?
                LIMIT ?
                """

            val retrieveStatement: PreparedStatement = connection.prepareStatement(retrieveQuery)

            retrieveStatement.setInt(1, subjectId)
            retrieveStatement.setInt(2, startId)
            retrieveStatement.setInt(3, endId)
            retrieveStatement.setInt(4, limit)


            val resultSet = retrieveStatement.executeQuery()

            while (resultSet.next()) {
                val result = StudentResults(
                    resultSet.getInt("student_id"),
                    resultSet.getInt("subject_id"),
                    resultSet.getInt("session_id"),
                    resultSet.getString("marks")
                )
                results.add(result)
            }
        } catch (e: SQLException) {
            e.printStackTrace()

        }
        val htmlStringBuilder = StringBuilder()
        htmlStringBuilder.append(
            """
        <!DOCTYPE html>
        <html lang="en">
        <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Student Enrollment</title>
        </head>
        <body>
        <h1>Results</h1>
    """
        )

        results.forEach { it ->
            htmlStringBuilder.append(
                """
              <div style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
            <h3>Student ID: ${it.studentId}</h3>
            <h3>Subject ID: ${it.subjectId}</h3>
            <h3>Mark: ${it.mark}</h3>
            </div>
        """
            )
        }

        htmlStringBuilder.append(
            """
        </body>
        </html>
    """
        )

        return htmlStringBuilder.toString()

    }

    @GetMapping("/delete/{studentId}")
    fun deleteResults(@PathVariable studentId: Int): String {
        try {
            val sqlURL = "jdbc:postgresql://leftshift.xyz:5433/university"
            val connection = DriverManager.getConnection(sqlURL, "postgres", "nikola9876")


            val deleteQuery = "DELETE FROM subject_results WHERE student_id = ?"
            val deleteStatement: PreparedStatement = connection.prepareStatement(deleteQuery)
            deleteStatement.setInt(1, studentId)
            val deletedRows = deleteStatement.executeUpdate()

            return if (deletedRows > 0) {
                "Subject results for Student ID $studentId deleted successfully."
            } else {
                "No subject results found for Student ID $studentId."
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            return "Error: " + e.message
        }
    }


}

@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}
