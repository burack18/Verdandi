package com.example.verdandibackend.dao;

import com.example.verdandibackend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
