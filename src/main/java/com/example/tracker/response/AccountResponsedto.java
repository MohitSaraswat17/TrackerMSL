package com.example.tracker.response;



import com.example.tracker.enums.AccountType;
import com.example.tracker.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponsedto {
    private Long accountId;
    private Long accountNumber;
    private AccountType accountype;
    private Long balance;
    private Long openingBalance;
    private Status status;
}
