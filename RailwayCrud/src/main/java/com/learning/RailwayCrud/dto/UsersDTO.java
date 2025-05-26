package com.learning.RailwayCrud.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsersDTO {
    private long userID;
    private long mobile_No;
    private String user_name;
    private String email_address;
    private String password;

    public UsersDTO(long userID, String userName) {
    }
}
