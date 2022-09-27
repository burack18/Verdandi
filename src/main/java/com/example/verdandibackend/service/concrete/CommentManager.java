package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.dao.CommentRepository;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.service.abstracts.CommentService;
import com.example.verdandibackend.utilities.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CommentManager implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;


    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }

    @Override
    public Comment getById(Integer id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public Comment add(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public CommentDto addLikeToComment(Integer commentid) {
        Comment comment = getById(commentid);
        comment.setLikeCount(comment.getLikeCount()+1);
        Comment savedComment = repository.save(comment);
        return mapper.convertToDto(savedComment);
    }


}
