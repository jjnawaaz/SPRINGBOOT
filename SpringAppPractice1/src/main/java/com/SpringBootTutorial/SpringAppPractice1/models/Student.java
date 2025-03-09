package com.SpringBootTutorial.SpringAppPractice1.models;


import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users") // Collection name in MongoDB
public class Student {
    @Id   // To make a unique id in MongoDB collection
    private ObjectId id;
    
    private String name;
    private String email;

    private LocalDateTime date;

    // Constructors
    public Student() {}


    // Getters and Setters
    public ObjectId
     getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
