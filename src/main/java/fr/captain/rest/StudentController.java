package fr.captain.rest;

import fr.captain.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
