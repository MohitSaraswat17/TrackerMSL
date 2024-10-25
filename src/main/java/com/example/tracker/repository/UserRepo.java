package com.example.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tracker.model.User;
import com.example.tracker.response.UserResponsedto;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
     @Query("SELECT new com.example.tracker.response.UserResponsedto(u.userName, u.email, u.occupationtype, u.organisationName) " +
           "FROM User u WHERE u.userId = :userId")
    UserResponsedto getUserDtoById(@Param("userId") Long userId);
    
}
