package com.example.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*;
import java.sql.DriverManager
import java.sql.PreparedStatement


data class Student(
    val studentId: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val enrolment: String
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

@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}
