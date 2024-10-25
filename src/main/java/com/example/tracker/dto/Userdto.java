package com.example.tracker.dto;

import com.example.tracker.enums.OccupationType;

import lombok.Data;

@Data
public class Userdto {
    private String userName;
    private String email;
    private String password;

    private OccupationType occupationtype;
    private String organisationName;
}
