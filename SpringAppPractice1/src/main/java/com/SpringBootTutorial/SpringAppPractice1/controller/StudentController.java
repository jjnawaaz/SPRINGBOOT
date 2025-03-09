package com.SpringBootTutorial.SpringAppPractice1.controller;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

   // Get all students
   @GetMapping("/students")
   public ResponseEntity<List<Student>> getAllStudents(){
     try {
      List<Student> students = studentService.getAllStudents();
      return new ResponseEntity<>(students, HttpStatus.OK);
     } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
   }
   
   // Post students
   @PostMapping("/students")
   public ResponseEntity<Student> createStudent(@RequestBody Student student){
    try {
      student.setDate(LocalDateTime.now());
      studentService.saveStudent(student);

      return new ResponseEntity<>(student,HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
    }
   }

   // Get student by id
   @GetMapping("/students/{id}")
   public ResponseEntity<Student> getStudentById(@PathVariable ObjectId id){
      
      try{
         Optional<Student> data = Optional.ofNullable(studentService.getStudentById(id));
         if(data.isPresent()){
            return new ResponseEntity<>(data.get(),HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
   }

   // Update student by id
   @PutMapping("/students/{id}")
   public ResponseEntity<Student> updateStudent(@PathVariable ObjectId id, @RequestBody Student student){
     try {
      Student old = studentService.getStudentById(id);
      if(old != null){
         old.setEmail(student.getEmail() != null && !student.getEmail().equals("") ? student.getEmail() : old.getEmail());
         old.setName(student.getName() != null && !student.getName().equals("") ? student.getName() : old.getName());
      }
      studentService.saveStudent(old);
      return new ResponseEntity<>(old,HttpStatus.OK);
     } catch (Exception e) {
     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
   }
   


   // Delete student by id
   @DeleteMapping("/students/{id}")
   public ResponseEntity<Student> deleteStudent(@PathVariable ObjectId id){
      try {
         studentService.deleteStudent(id);
         return new ResponseEntity<>(HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
   }

}

