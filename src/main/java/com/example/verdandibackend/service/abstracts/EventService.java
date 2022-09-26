package com.example.verdandibackend.service.abstracts;

import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAll();
    Event add(Event event);
    Event getEventById(Integer id);

    void addComment(Integer id, Comment comment);
}
