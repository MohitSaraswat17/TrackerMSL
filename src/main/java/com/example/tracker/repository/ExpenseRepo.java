package com.example.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tracker.model.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    @Query("SELECT SUM(e.amount) from Expense e where e.user.userId = :userId")
    Long getTotalExpensebyUserId(@Param("userId") Long userId);
}
