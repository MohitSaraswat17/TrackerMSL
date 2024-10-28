package com.example.tracker.dto;

import java.time.LocalDateTime;

import com.example.tracker.enums.PaymentMethod;
import com.example.tracker.enums.TransactionType;

import lombok.Data;

@Data
public class TransactionDTO {
    private Long transactionId;
    private Long userId;
    private TransactionType transactionType;
    private Long transactionAmount;
    private PaymentMethod paymentMethod;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}