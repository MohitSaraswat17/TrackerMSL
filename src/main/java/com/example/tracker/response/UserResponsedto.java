package com.example.tracker.response;

import com.example.tracker.enums.OccupationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponsedto {
    private String userName;
    private String email;
    private OccupationType occupationType;
    private String organisationName;
}
