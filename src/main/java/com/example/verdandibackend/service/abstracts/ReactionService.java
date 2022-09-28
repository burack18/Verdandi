package com.example.verdandibackend.service.abstracts;

import com.example.verdandibackend.model.Reaction;
import com.example.verdandibackend.model.enums.ReactionType;

public interface ReactionService {
    Reaction getById(Integer id);
    Integer getAllByEvent_IdAndReactionType(Integer id, ReactionType reactionType);

}
