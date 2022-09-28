package com.example.verdandibackend;

import com.example.verdandibackend.utilities.mapper.ApplicationUserMapper;
import com.example.verdandibackend.utilities.mapper.CommentMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VerdandiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerdandiBackendApplication.class, args);
    }


}
