package com.example.tracker.model;

import java.time.LocalDateTime;

import com.example.tracker.enums.OccupationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AuditUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    private Long userId;
    private String userName;
    private String email;
    private String password;

    private OccupationType occupationtype;
    private String organisationName;

    private String operationType; // UPDATE or DELETE
    private LocalDateTime operationTimestamp;
}
