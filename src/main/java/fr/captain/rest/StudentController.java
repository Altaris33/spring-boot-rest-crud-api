package fr.captain.rest;

import fr.captain.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Captain", "Falcon"));
        students.add(new Student("Ganon", "Dorf"));
        students.add(new Student("Rean", "Scharzer"));
        students.add(new Student("Alisa", "Reinford"));

        return students;
    }
}
