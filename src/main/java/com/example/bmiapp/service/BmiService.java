package com.example.bmiapp.service;

import com.example.bmiapp.model.BmiRecord;
import com.example.bmiapp.model.User;
import com.example.bmiapp.repository.BmiRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BmiService {

    @Autowired
    private BmiRecordRepository bmiRecordRepository;

    public BmiRecord calculateAndSaveBmi(User user, double weight, double height) {
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        String category = getBmiCategory(bmi);

        BmiRecord record = new BmiRecord();
        record.setUser(user);
        record.setWeight(weight);
        record.setHeight(height);
        record.setBmi(bmi);
        record.setCategory(category);
        record.setCreatedAt(LocalDateTime.now());

        return bmiRecordRepository.save(record);
    }

    public List<BmiRecord> getUserBmiHistory(User user) {
        return bmiRecordRepository.findByUserOrderByCreatedAtDesc(user);
    }

    private String getBmiCategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal weight";
        if (bmi < 30) return "Overweight";
        return "Obesity";
    }
} 