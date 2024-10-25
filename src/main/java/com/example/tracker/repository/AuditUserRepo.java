package com.example.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tracker.model.AuditUser;

@Repository
public interface AuditUserRepo extends JpaRepository<AuditUser,Long> {

}
