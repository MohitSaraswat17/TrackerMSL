package com.example.tracker.model;

import com.example.tracker.enums.Status;

import java.time.LocalDateTime;


import com.example.tracker.enums.AccountType;

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
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private Long accountNumber;


    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountype;


    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    private Long balance;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long openingBalance;

    public void setStatus(Status status){
        this.status=status;
    }

    

   
}
