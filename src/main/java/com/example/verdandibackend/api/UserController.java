package com.example.verdandibackend.api;

import com.example.verdandibackend.api.dto.RegisterUserDto;
import com.example.verdandibackend.service.abstracts.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final ApplicationUserService service;


    @PostMapping("/register")
    public ResponseEntity register(@ModelAttribute RegisterUserDto user) throws IOException {
        return ResponseEntity.ok().body(service.add(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity register(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
