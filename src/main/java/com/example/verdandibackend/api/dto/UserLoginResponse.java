package com.example.verdandibackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private Long userScore;
    private byte[] foto;
}
