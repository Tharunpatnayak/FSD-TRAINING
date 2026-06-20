package com.example.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(
            @RequestBody Student student) {

        Student savedStudent =
        studentService.addStudent(student);

        return ResponseEntity.ok(
                savedStudent
        );

    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> students =
        studentService.getAllStudents();

        return ResponseEntity.ok(
                students
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(
            @PathVariable Long id) {

        Student student =
        studentService.getStudentById(id);

        if(student != null) {

            return ResponseEntity.ok(
                    student
            );

        }

        return ResponseEntity.badRequest()
                .body(
                        "Student Not Found"
                );

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student updatedStudent =
        studentService.updateStudent(
                id,
                student
        );

        if(updatedStudent != null) {

            return ResponseEntity.ok(
                    updatedStudent
            );

        }

        return ResponseEntity.badRequest()
                .body(
                        "Student Not Found"
                );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(
            @PathVariable Long id) {

        boolean deleted =
        studentService.deleteStudent(id);

        if(deleted) {

            return ResponseEntity.ok(
                    "Student Deleted Successfully"
            );

        }

        return ResponseEntity.badRequest()
                .body(
                        "Student Not Found"
                );

    }

}