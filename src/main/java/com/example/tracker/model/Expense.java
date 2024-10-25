package com.example.tracker.model;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.tracker.enums.ExpenseCategory;
import com.example.tracker.enums.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    @Enumerated(EnumType.STRING)
    @Column(name = "expense_category")
    private ExpenseCategory expensecategory;

    private int amount;
   
    private String description;

    
    private Date expenseDate;

   
    private LocalDateTime createdAt;

   
    private LocalDateTime updatedAt;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

   
    private boolean isRecurring;


}
