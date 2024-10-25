package com.example.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tracker.dto.Expensedto;
import com.example.tracker.model.Expense;
import com.example.tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/create/{id}")
    public ResponseEntity<Expense> createExpense(@PathVariable Long id, @RequestBody Expensedto expenseDTO) {
        Expense newExpense = expenseService.createExpense(id, expenseDTO);
        
        return ResponseEntity.ok(newExpense);
    }
     @PutMapping("/update/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expensedto expenseDTO) {
        Expense updatedExpense = expenseService.updateExpense(id, expenseDTO);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    @GetMapping("/total-expense/{userId}")
    public Long getTotalExpense(@PathVariable Long userId){
        return expenseService.getTotalExpenseForUser(userId);
    }
    
     
    
}
