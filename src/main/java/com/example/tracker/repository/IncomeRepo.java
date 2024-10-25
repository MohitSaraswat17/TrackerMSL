package com.example.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tracker.model.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income,Long> {

    @Query("SELECT SUM(i.amount) FROM Income i WHERE i.user.userId = :userId")
    Long getTotalIncomeByUserId(@Param("userId") Long userId);

}
