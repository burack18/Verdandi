package com.example.verdandibackend.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public CommentMapper getCMapper(){
        return new CommentMapper(new ModelMapper());
    };
    @Bean
    public ApplicationUserMapper getAMapper(){
        return new ApplicationUserMapper(new ModelMapper());
    };
}
