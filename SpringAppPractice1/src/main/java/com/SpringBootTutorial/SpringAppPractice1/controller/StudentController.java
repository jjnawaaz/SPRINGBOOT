package com.SpringBootTutorial.SpringAppPractice1.controller;


import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootTutorial.SpringAppPractice1.models.Student;
import com.SpringBootTutorial.SpringAppPractice1.service.StudentService;


@RestController
@RequestMapping("/api/v1")
public class StudentController {
    
   @Autowired
   private StudentService studentService;

   @GetMapping("/students")
   public List<Student> getAllStudents(){
      return studentService.getAllStudents();
   }
   
   @PostMapping("/students")
   public Student createStudent(@RequestBody Student student){
      return studentService.saveStudent(student);
   }

}

