package com.example.verdandibackend.api.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private Long userScore;
    private MultipartFile foto;
}
