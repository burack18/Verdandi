package com.example.verdandibackend.service.abstracts;

import com.example.verdandibackend.model.Document;

public interface DocumentService {
    Document add(Document document);
    Document getById(Integer id);
    Document getByUserId(Integer userId);
}
