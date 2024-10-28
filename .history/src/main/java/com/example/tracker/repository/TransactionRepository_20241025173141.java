package com.example.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tracker.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}