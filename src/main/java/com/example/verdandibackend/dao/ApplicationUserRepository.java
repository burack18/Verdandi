package com.example.verdandibackend.dao;

import com.example.verdandibackend.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Integer> {
}
