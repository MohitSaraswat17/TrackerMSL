package com.example.tracker.controller;

import com.example.tracker.model.Income;
import com.example.tracker.service.IncomeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eta")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping("/income")   //new income
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        Income createdIncome = incomeService.createIncome(income);
        return ResponseEntity.ok(createdIncome);
    }

    @PutMapping("/income/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income updatedIncome) {
        try {
            Income income = incomeService.updateIncome(id, updatedIncome);
            return ResponseEntity.ok(income);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
