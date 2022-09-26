package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.dao.EventRepository;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.service.abstracts.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class EventManager implements EventService {

    private final EventRepository repository;

    @Override
    public List<Event> getAll() {
        return repository.findAll();
    }

    @Override
    public Event add(Event event) {
        return repository.save(event);
    }

    @Override
    public Event getEventById(Integer id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public void addComment(Integer id, Comment comment) {
        Event event=getEventById(id);
        event.getComments().add(comment);
        repository.save(event);
    }
}
