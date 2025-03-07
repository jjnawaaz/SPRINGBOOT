package com.SpringBootTutorial.SpringAppPractice1.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootTutorial.SpringAppPractice1.models.Student;

@Repository   // To let spring know it is a repository
public interface studentRepo extends MongoRepository< Student,ObjectId> {
    Student findByEmail(String Email);
}
