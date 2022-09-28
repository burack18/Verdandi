package com.example.verdandibackend.dao;

import com.example.verdandibackend.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Integer> {
    Optional<ApplicationUser> findByEmail(String email);
}
