package com.example.verdandibackend.service.abstracts;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.model.enums.ReactionType;

import java.util.List;

public interface EventService {
    List<Event> getAll();
    Event add(Event event);
    Event getEventById(Integer id);

    Comment addComment(Integer id, CommentDto commentDto);


    void addLikeToEvent(Integer id,ReactionType type);

    void deleteById(Integer id);

    Integer getCountOfReaction(Integer id, ReactionType type);
}
