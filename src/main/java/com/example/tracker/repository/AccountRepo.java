package com.example.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tracker.model.Accounts;
import com.example.tracker.response.AccountResponsedto;

@Repository
public interface AccountRepo extends JpaRepository<Accounts,Long>{

    @Query("SELECT new com.example.tracker.response.AccountResponsedto(a.accountId, a.accountNumber, a.accountype,a.balance,a.openingBalance,a.status) " +
    "FROM Accounts a WHERE a.user.userId = :userId")
    List<AccountResponsedto> getAllAccountDtosByUserId(@Param("userId") Long userId);

    @Query("SELECT SUM(a.balance) FROM Accounts a WHERE a.user.userId = :userId")
    Long getTotalBalanceByUserId(@Param("userId") Long userId);
}

