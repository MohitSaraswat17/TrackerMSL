package com.example.tracker.dto;

import java.time.LocalDateTime;
import java.sql.Date;
import com.example.tracker.enums.ExpenseCategory;
import com.example.tracker.enums.PaymentMethod;

import lombok.Data;
@Data
public class Expensedto {
private Long expenseId; 
    private Long userId; 
    private ExpenseCategory expenseCategory; 
    private int amount; 
    private String Description; 
    private Date expenseDate; 
    private PaymentMethod PaymentMethod; 
    private boolean isRecurring;    
    
}
