package com.example.blog
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*;
import java.util.Date

interface StudentRepository : JpaRepository<Student, Int>
interface FacultyRepository : JpaRepository<Faculty, Int>
interface SubjectResultsRepository : JpaRepository<SubjectResults, Int> {
    fun findByStudentId(studentId: Int): MutableList<SubjectResults>
}
interface SessionsRepository : JpaRepository<Sessions, Int>
interface SubjectRepository : JpaRepository<Subject, Int>
interface StudentFacultyRepository : JpaRepository<StudentFaculty, Int> {
    fun findByStudentId(studentId: Int): StudentFaculty?
}

@Entity
@Table(name = "student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    val id: Int,
    val name: String,
    @Column(name = "enrolment_status")
    val enrollStatus: String,
    val age: Int,
    @Column(name = "current_student")
    val currentStatus: Boolean
)

@Entity
data class Faculty(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    val facultyId: Int,
    @Column(name = "faculty_name")
    val facultyName: String,
    val campus: String,
)

@Entity
data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    val subjectId: Int,
    val name: String,
    @Column(name = "level_code")
    val subjectLevel: Int,
    val campus: String,
)

@Entity
data class SubjectResults(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    val resultId: Int,
    @Column(name = "student_id")
    val studentId: Int,
    @Column(name = "subject_id")
    val subjectId: Int,
    val marks: String,
    @Column(name = "session_id")
    val sessionId: Int,
)

@Entity
data class Sessions(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    val sessionId: Int,
    val semester: String,
    val year: Int
)

@Entity
data class StudentFaculty(
    @Id
    @Column(name = "student_id")
    val studentId: Int,
    @Column(name = "faculty_id")
    val facultyId: Int,
    @Column(name = "join_date")
    val joiningDate: Date
)

data class Marks(val subject: String, val mark: String, val session: String)


@Controller
class StudentController(
    val studentRepository: StudentRepository,
    val facultyRepository: FacultyRepository,
    val subjectResultsRepository: SubjectResultsRepository,
    val sessionsRepository: SessionsRepository,
    val subjectRepository: SubjectRepository,
    val studentFacultyRepository: StudentFacultyRepository
) {

    @GetMapping("/search")
    fun getResults(@RequestParam id: Int, model: Model): String {
        val student = studentRepository.findById(id)

        return if (student.isPresent) {
            val sData = student.get()
            model.addAttribute("name", sData.name)
            model.addAttribute("id", sData.id)
            model.addAttribute("age", sData.age)
            model.addAttribute("enrol", sData.enrollStatus)
            model.addAttribute("currentStatus", sData.currentStatus)
            "results"
        } else {
            model.addAttribute("errorMessage", "Student not found with ID $id")
            "error"
        }

    }

    @GetMapping("/student/{id}/transcript")
    fun getTranscript(@PathVariable id: Int, model: Model): String {

        val studentFaculty = studentFacultyRepository.findByStudentId(id)

        return if (studentFaculty != null) {
            val subjectResultsList = subjectResultsRepository.findByStudentId(id)
            val student = studentRepository.findById(id).get().name
            val faculty = facultyRepository.findById(studentFaculty.facultyId).get()//name,campus

            val marksList = mutableListOf<Marks>()

            for (subjectResult in subjectResultsList) {
                val subject = subjectRepository.findById(subjectResult.subjectId).get().name
                val mark = subjectResult.marks
                val session = sessionsRepository.findById(subjectResult.sessionId).get().semester
                marksList.add(Marks(subject, mark, session))
            }

            model.addAttribute("name", student)
            model.addAttribute("faculty", faculty.facultyName)
            model.addAttribute("campus", faculty.campus)
            model.addAttribute("marks", marksList)

            "transcript"
        } else {
            model.addAttribute("errorMessage", "Student doesn't have any marks")
            "error"
        }
    }

}


@SpringBootApplication
class StudentApplication

fun main(args: Array<String>) {
    runApplication<StudentApplication>(*args)
}