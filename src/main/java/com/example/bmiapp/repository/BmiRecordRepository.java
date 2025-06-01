package com.example.bmiapp.repository;

import com.example.bmiapp.model.BmiRecord;
import com.example.bmiapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BmiRecordRepository extends JpaRepository<BmiRecord, Long> {
    List<BmiRecord> findByUserOrderByCreatedAtDesc(User user);
} 