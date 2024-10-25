package com.example.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tracker.dto.Accountsdto;
import com.example.tracker.model.Accounts;
import com.example.tracker.response.AccountResponsedto;
import com.example.tracker.service.AccountsService;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountsService accountService;

     @PostMapping("/create/{id}")
    public ResponseEntity<Accounts> createAccount(@PathVariable Long id,@RequestBody Accountsdto accountdto){
        Accounts accounts = accountService.createAccount(id,accountdto);
        return new ResponseEntity<>(accounts, HttpStatus.CREATED);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<AccountResponsedto>> getAllAccounts(@PathVariable Long userId){
        return accountService.getAllAccounts(userId);
    }
    
    @GetMapping("/total-balance/{userId}")
    public Long getTotalBalance(@PathVariable Long userId) {
        return accountService.getTotalBalanceForUser(userId);
    }
}
