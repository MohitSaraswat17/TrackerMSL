package com.example.tracker.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tracker.dto.Accountsdto;
import com.example.tracker.model.Accounts;
import com.example.tracker.model.User;
import com.example.tracker.repository.AccountRepo;
import com.example.tracker.repository.UserRepo;
import com.example.tracker.response.AccountResponsedto;

@Service
public class AccountsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AccountRepo accountRepo;


    public Accounts createAccount(Long userId,Accountsdto accountdto){
        User currentUser = userRepo.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id: "+ userId));

        Accounts account = new Accounts();

        account.setAccountNumber(accountdto.getAccountNumber());
        account.setUser(currentUser);
        account.setAccountype(accountdto.getAccountType());
        account.setStatus(accountdto.getStatus());
        account.setOpeningBalance(accountdto.getOpeningBalance());
        account.setCreatedAt(LocalDateTime.now());
        account.setBalance(accountdto.getOpeningBalance());

        return accountRepo.save(account);
    }

    public ResponseEntity<List<AccountResponsedto>> getAllAccounts(Long userId){
        List<AccountResponsedto> accounts = accountRepo.getAllAccountDtosByUserId(userId);
        return ResponseEntity.ok(accounts);
    }

    public Long getTotalBalanceForUser(Long userId) {
        Long totalBalance = accountRepo.getTotalBalanceByUserId(userId);
        return totalBalance != null ? totalBalance : 0; // Return 0 if no accounts found
    }

    

    

}
