package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.dao.CommentRepository;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Reaction;
import com.example.verdandibackend.model.enums.ReactionType;
import com.example.verdandibackend.service.abstracts.CommentService;
import com.example.verdandibackend.service.abstracts.ReactionService;
import com.example.verdandibackend.utilities.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CommentManager implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;
    private final ReactionService reactionService;


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
    public void addReactionToComment(Integer commentid, ReactionType type) {
        Comment comment = getById(commentid);
        Reaction reaction=new Reaction(comment,type);
        reactionService.add(reaction);
    }
}
