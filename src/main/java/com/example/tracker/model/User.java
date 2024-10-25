package com.example.tracker.model;

import java.time.LocalDateTime;
import java.util.List;

import com.example.tracker.enums.OccupationType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String email;
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)  
    @Column(name="occupationtype")  
    private OccupationType occupationtype;
    
    private String organisationName;

    // Wrong name
    // need of join column explain kar mujhe need samjh nahi aayi
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // , orphanRemoval = true think about in future
    private List<Expense> expenses;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private  List<Income> income;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private  List<Accounts> accounts;



    

}
