package com.SpringBootTutorial.SpringAppPractice1.service;

import java.time.LocalDateTime;
import java.util.List;

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

    public Student getStudentById(ObjectId id){
        return studentRepo.findById(id).orElse(null);
    }

    // Post students service
    public Student saveStudent(Student student){
        student.setDate(LocalDateTime.now());
        return studentRepo.save(student);
    }

    // Delete student by id
    public void deleteStudent(ObjectId id){
        studentRepo.deleteById(id);
    }
}
