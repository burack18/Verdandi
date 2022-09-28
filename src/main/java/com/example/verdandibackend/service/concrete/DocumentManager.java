package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.dao.DocumentRepository;
import com.example.verdandibackend.model.Document;
import com.example.verdandibackend.service.abstracts.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentManager implements DocumentService {
    private final DocumentRepository repository;
    @Override
    public Document add(Document document) {
        return repository.save(document);
    }

    @Override
    public Document getById(Integer id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public Document getByUserId(Integer userId) {
        return repository.findFirstByUser_Id(userId);
    }
}
