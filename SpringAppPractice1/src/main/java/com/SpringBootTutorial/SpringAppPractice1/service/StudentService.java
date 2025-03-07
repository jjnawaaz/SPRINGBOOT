package com.SpringBootTutorial.SpringAppPractice1.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootTutorial.SpringAppPractice1.models.Student;
import com.SpringBootTutorial.SpringAppPractice1.repo.studentRepo;

@Service   // To let SpringBoot know it is a Service
public class StudentService {
    @Autowired
    private studentRepo studentRepo;

    // Get all students service
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    // Get By User ID
    public Student getStudentbyEmail(String email){
        return studentRepo.findByEmail(email);
    }

    public Optional<Student> getStudentById(ObjectId id){
        return studentRepo.findById(id);
    }

    // Post students service
    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }
}
