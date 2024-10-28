package com.example.tracker.dto;

import java.time.LocalDate;

public class IncomeDto {
    private Long userId;
    private Long sourceId;
    private Long accountId;  
    private Long amount;
    private String description;
    private LocalDate incomeDate;
    private String destination;  

}