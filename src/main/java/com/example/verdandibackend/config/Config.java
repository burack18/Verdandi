package com.example.verdandibackend.config;

import com.example.verdandibackend.config.filter.JwtAuthorizationFilter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder BcrypEncode(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public JwtAuthorizationFilter jwtAuthenticationFilter() {
        return new JwtAuthorizationFilter();
    }

}