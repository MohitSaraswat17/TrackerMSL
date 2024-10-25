package com.example.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tracker.model.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {

}
