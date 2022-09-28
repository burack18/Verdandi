package com.example.verdandibackend.service.abstracts;

import com.example.verdandibackend.api.dto.RegisterUserDto;
import com.example.verdandibackend.api.dto.UserLoginResponse;
import com.example.verdandibackend.model.ApplicationUser;

import java.io.IOException;

public interface ApplicationUserService {
    ApplicationUser add(RegisterUserDto user) throws IOException;
    UserLoginResponse getById(Integer id);
}
