package com.example.tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tracker.dto.TransactionDTO;
import com.example.tracker.enums.PaymentMethod;
import com.example.tracker.enums.TransactionType;
import com.example.tracker.model.Transaction;
import com.example.tracker.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction createTransaction(TransactionDTO transactionDto) {
        Transaction transaction = new Transaction();
       
        transaction.setTransactionId(transactionDto.getTransactionId());
        transaction.setTransactionAmount(transactionDto.getTransactionAmount());
        transaction.setTransactiontype(TransactionType.INCOME);
        transaction.setPaymentmethod(PaymentMethod.CASH);
        transaction.setCreatedAt(transactionDto.getCreatedAt());
        transaction.setUpdatedAt(transactionDto.getUpdatedAt());

        return transactionRepository.save(transaction);
    }


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

   
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction updateTransaction(Long id, TransactionDTO transactionDto) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            transaction.setTransactionAmount(transactionDto.getTransactionAmount());
            transaction.setTransactiontype(transactionDto.getTransactionType());
            transaction.setPaymentmethod(transactionDto.getPaymentMethod());
            transaction.setUpdatedAt(transactionDto.getUpdatedAt());
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found.");
        }
    }
}
