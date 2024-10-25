package com.example.tracker.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tracker.dto.Expensedto;
import com.example.tracker.enums.ExpenseCategory;
import com.example.tracker.enums.PaymentMethod;
import com.example.tracker.model.Expense;
import com.example.tracker.model.User;
import com.example.tracker.repository.ExpenseRepo;
import com.example.tracker.repository.UserRepo;

@Service
public class ExpenseService {
     @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private UserRepo userRepo;  

    public Expense createExpense(Long id,Expensedto expensedto){
        Expense expense = new Expense();

        User existingUser = userRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found")); 


        expense.setUser(existingUser); 
        expense.setAmount(expensedto.getAmount());        
        expense.setDescription(expensedto.getDescription());
        expense.setExpenseDate(expensedto.getExpenseDate());
        expense.setPaymentMethod(PaymentMethod.CASH);
        expense.setExpensecategory(ExpenseCategory.ENTERTAINMENT);
        expense.setCreatedAt(LocalDateTime.now());
        expense.setUpdatedAt(LocalDateTime.now());
        

        return expenseRepo.save(expense);

    }

    public Expense updateExpense(Long expenseId, Expensedto expensedto) {
        Expense existingExpense = expenseRepo.findById(expenseId)
        .orElseThrow(() -> new RuntimeException("Expense not found"));        
        
        existingExpense.setExpenseId(expenseId);
        existingExpense.setAmount(existingExpense.getAmount());
        existingExpense.setDescription(existingExpense.getDescription());
        existingExpense.setPaymentMethod(PaymentMethod.CASH);
        existingExpense.setExpensecategory(ExpenseCategory.ENTERTAINMENT);
        existingExpense.setRecurring(false);
        existingExpense.setExpenseDate(existingExpense.getExpenseDate());
        
    if (expensedto.getPaymentMethod() != null) {
        existingExpense.setPaymentMethod(expensedto.getPaymentMethod());
    }
    if (expensedto.getDescription() != null) {
        existingExpense.setDescription(expensedto.getDescription());
    }
    // Set updated date/time
    existingExpense.setUpdatedAt(LocalDateTime.now());

    return expenseRepo.save(existingExpense);
    }

    public Long getTotalExpenseForUser(Long userId){
        Long totalexpense = expenseRepo.getTotalExpensebyUserId(userId);

        return totalexpense!=null ? totalexpense : 0;
    }


}
