package com.example.verdandibackend.service.abstracts;

import com.example.verdandibackend.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();
    Comment add(Comment comment);
}
