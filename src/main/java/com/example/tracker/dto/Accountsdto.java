package com.example.tracker.dto;



import com.example.tracker.enums.AccountType;
import com.example.tracker.enums.Status;

import lombok.Data;

@Data
public class Accountsdto {
    private Long AccountNumber;
    private AccountType AccountType;
    private Status status;
    private Long openingBalance;
}
