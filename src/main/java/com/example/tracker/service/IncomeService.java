

package com.example.tracker.service;

import com.example.tracker.model.Income;
import com.example.tracker.repository.IncomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepo incomeRepository;
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    public Income updateIncome(Long id, Income updatedIncome) {
        return incomeRepository.findById(id).map(income -> {
            income.setUser(updatedIncome.getUser());
            income.setIncomeSource(updatedIncome.getIncomeSource());
            income.setAmount(updatedIncome.getAmount());
            income.setDescription(updatedIncome.getDescription());
            income.setCreatedAt(updatedIncome.getCreatedAt());
            income.setUpdatedAt(updatedIncome.getUpdatedAt());
            income.setRecurring(updatedIncome.isRecurring());
            return incomeRepository.save(income);
        }).orElseThrow(() -> new RuntimeException("Income not found with id " + id));
    }
}

