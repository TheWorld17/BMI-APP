package com.example.bmiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.bmiapp.model")
@EnableJpaRepositories("com.example.bmiapp.repository")
public class BmiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BmiApplication.class, args);
    }
} 