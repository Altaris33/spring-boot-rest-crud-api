package fr.captain.rest;

import fr.captain.entity.Student;
import fr.captain.exception.StudentErrorResponse;
import fr.captain.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        if (id >= students.size() || id < 0) {
            throw new StudentNotFoundException("Student id not found : " + id);
        }
        return students.get(id);
    }

    @PostConstruct
    public void loadStudents() {
        students = new ArrayList<>();
        students.add(new Student(1, "Captain", "Falcon"));
        students.add(new Student(2, "Ganon", "Dorf"));
        students.add(new Student(3, "Rean", "Scharzer"));
        students.add(new Student(4, "Alisa", "Reinford"));
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(Timestamp.from(Instant.now()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(Timestamp.from(Instant.now()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
