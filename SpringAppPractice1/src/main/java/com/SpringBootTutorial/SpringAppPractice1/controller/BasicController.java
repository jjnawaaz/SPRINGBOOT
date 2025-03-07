package com.SpringBootTutorial.SpringAppPractice1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootTutorial.SpringAppPractice1.entity.StudentEntity;


@RestController
@RequestMapping("/home")
public class BasicController {
    
 private Map<Integer, StudentEntity> studentMap = new HashMap<>();

 @GetMapping("/student")   // localhost:8080/home/student for Getting the data 
 public List<StudentEntity> getAll(){
    return new ArrayList<>(studentMap.values());
 }


 @PostMapping("/student")   // localhost:8080/home/student for Posting the data
 public boolean  postEntity(@RequestBody StudentEntity studentEntity){
    studentMap.put(studentEntity.getId(),studentEntity);
    return true;
 }


 @GetMapping("/student/{id}") //localhost:8080/home/student/1 for Getting the data by id
 public StudentEntity getEntityById(@PathVariable int id){
    return studentMap.get(id);
 }

 @DeleteMapping("/student/{id}") //localhost:8080/home/student/1 for Deleting the data by id
   public boolean deleteEntityById(@PathVariable int id){
    studentMap.remove(id);
    return true;
   }

   @PutMapping("/student/{id}") //localhost:8080/home/student/1 for Updating the data by id
   public boolean updateEntityById(@PathVariable int id, @RequestBody StudentEntity studentEntity){
    studentMap.put(id,studentEntity);
    return true;
   }
}
