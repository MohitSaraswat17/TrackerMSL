package com.example.tracker.model;

import java.time.LocalDateTime;

import com.example.tracker.enums.PaymentMethod;
import com.example.tracker.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name="user_id")    
    private User user;

    @Enumerated
   @Column(name = "transaction_type")
    private TransactionType transactiontype;

    private Long TransactionAmount;

    @Enumerated
    @Column(name = "payment_method")
    private PaymentMethod paymentmethod;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
