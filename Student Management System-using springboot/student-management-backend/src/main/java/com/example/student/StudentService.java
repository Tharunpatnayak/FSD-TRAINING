package com.example.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {

        return studentRepository.save(student);

    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();

    }

    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElse(null);

    }

    public Student updateStudent(Long id,
                                 Student updatedStudent) {

        Student existingStudent =
        studentRepository.findById(id)
                .orElse(null);

        if(existingStudent == null) {

            return null;

        }

        existingStudent.setName(
                updatedStudent.getName()
        );

        existingStudent.setAge(
                updatedStudent.getAge()
        );

        existingStudent.setRollno(
                updatedStudent.getRollno()
        );

        existingStudent.setCgpa(
                updatedStudent.getCgpa()
        );

        return studentRepository.save(
                existingStudent
        );

    }

    public boolean deleteStudent(Long id) {

        if(studentRepository.existsById(id)) {

            studentRepository.deleteById(id);

            return true;

        }

        return false;

    }

}