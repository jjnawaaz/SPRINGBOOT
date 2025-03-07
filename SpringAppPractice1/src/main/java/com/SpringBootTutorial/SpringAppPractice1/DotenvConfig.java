package com.SpringBootTutorial.SpringAppPractice1;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {
    static {
        Dotenv dotenv = Dotenv.load(); // Load .env file
        System.setProperty("MONGO_URI", dotenv.get("MONGO_URI")); // Set as system property
        System.setProperty("PORT", dotenv.get("PORT"));
        System.setProperty("MONGO_DB", dotenv.get("MONGO_DB"));
    }
}