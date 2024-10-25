package com.example.tracker.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tracker.dto.Userdto;
import com.example.tracker.enums.AccountType;
import com.example.tracker.enums.Status;
import com.example.tracker.model.Accounts;
import com.example.tracker.model.AuditUser;
import com.example.tracker.model.User;
import com.example.tracker.repository.AccountRepo;
import com.example.tracker.repository.AuditUserRepo;
import com.example.tracker.repository.UserRepo;
import com.example.tracker.response.UserResponsedto;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuditUserRepo auditUserRepo;

    @Autowired
    private AccountRepo accountRepo;

    public User createUser(Userdto userdto){
        User user = new User();
        user.setUserName(userdto.getUserName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setOccupationtype(userdto.getOccupationtype());
        user.setOrganisationName(userdto.getOrganisationName());
        user.setCreatedAt(LocalDateTime.now());
        User savedUser = userRepo.save(user);

        // Create a Default CASH_WALLET account for the User.
        Accounts defaultaccount = new Accounts();
        defaultaccount.setAccountNumber(savedUser.getUserId());
        defaultaccount.setAccountype(AccountType.CASH_WALLET);
        defaultaccount.setStatus(Status.ACTIVE);
        defaultaccount.setBalance(0L);
        defaultaccount.setOpeningBalance(0L);
        defaultaccount.setCreatedAt(LocalDateTime.now());
        defaultaccount.setUser(savedUser);
        accountRepo.save(defaultaccount);
        return savedUser;

    }

    public User updateUser(Long userId, Userdto userdto){
        // Fetch the current User.
        User currentUser = userRepo.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id: "+userId));
        
        // Update the User

        AuditUser auditUser = new AuditUser();
        auditUser.setUserId(userId);
        auditUser.setUserName(currentUser.getUserName());
        auditUser.setEmail(currentUser.getEmail());
        auditUser.setOccupationtype(currentUser.getOccupationtype());
        auditUser.setOrganisationName(currentUser.getOrganisationName());
        auditUser.setOperationType("UPDATE");
        auditUser.setOperationTimestamp(LocalDateTime.now());

        auditUserRepo.save(auditUser);

        if(userdto.getUserName() != null){
            currentUser.setUserName(userdto.getUserName());
        }
        if(userdto.getEmail() != null){
            currentUser.setEmail(userdto.getEmail());
        }
        if(userdto.getPassword() != null){
            currentUser.setPassword(userdto.getPassword());
        }
        if(userdto.getOccupationtype() != null){
            currentUser.setOccupationtype(userdto.getOccupationtype());
        }
        if(userdto.getOrganisationName() != null){
            currentUser.setOrganisationName(userdto.getOrganisationName());
        }

        currentUser.setUpdatedAt(LocalDateTime.now());

        return userRepo.save(currentUser);
    }

    public UserResponsedto getUserDtoById(Long userId) {
        return userRepo.getUserDtoById(userId);
    }
    
}
