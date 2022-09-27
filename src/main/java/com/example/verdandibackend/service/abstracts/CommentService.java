package com.example.verdandibackend.service.abstracts;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();
    Comment getById(Integer id);
    Comment add(Comment comment);

    CommentDto addLikeToComment(Integer commentid);
}
