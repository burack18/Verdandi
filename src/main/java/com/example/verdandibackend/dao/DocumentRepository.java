package com.example.verdandibackend.dao;

import com.example.verdandibackend.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
    Document findFirstByUser_Id(Integer userId);
}
