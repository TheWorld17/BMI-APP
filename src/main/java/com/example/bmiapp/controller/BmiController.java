package com.example.bmiapp.controller;

import com.example.bmiapp.model.BmiRecord;
import com.example.bmiapp.model.User;
import com.example.bmiapp.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bmi")
public class BmiController {

    @Autowired
    private BmiService bmiService;

    @GetMapping("/calculate")
    public String showCalculator() {
        return "bmi-calculator";
    }

    @PostMapping("/calculate")
    public String calculateBmi(
            @AuthenticationPrincipal User user,
            @RequestParam Double weight,
            @RequestParam Double height,
            Model model) {
        
        BmiRecord record = bmiService.calculateAndSaveBmi(user, weight, height);
        model.addAttribute("bmiRecord", record);
        return "bmi-result";
    }

    @GetMapping("/history")
    public String showHistory(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("bmiRecords", bmiService.getUserBmiHistory(user));
        return "bmi-history";
    }
} 