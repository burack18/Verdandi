package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.dao.CommentRepository;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.service.abstracts.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CommentManager implements CommentService {

    private final CommentRepository repository;


    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }

    @Override
    public Comment add(Comment comment) {
        return repository.save(comment);
    }
}
