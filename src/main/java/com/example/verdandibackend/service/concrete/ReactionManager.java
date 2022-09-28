package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.dao.ReactionRepository;
import com.example.verdandibackend.model.Reaction;
import com.example.verdandibackend.model.enums.ReactionType;
import com.example.verdandibackend.service.abstracts.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReactionManager implements ReactionService {

    private final ReactionRepository repository;

    @Override
    public Reaction getById(Integer id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public Reaction add(Reaction reaction) {
        return repository.save(reaction);
    }

    @Override
    public Integer getAllByEvent_IdAndReactionType(Integer id, ReactionType reactionType) {
        return repository.getAllByEvent_IdAndReactionType(id,reactionType);
    }
}
