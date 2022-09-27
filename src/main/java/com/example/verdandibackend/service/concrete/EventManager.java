package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.dao.EventRepository;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.service.abstracts.EventService;
import com.example.verdandibackend.utilities.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventManager implements EventService {

    private final EventRepository repository;
    private final CommentMapper mapper;

    @Override
    public List<Event> getAll() {
        return repository.findAll();
    }

    @Override
    public Event add(Event event) {
        event.setCreateTime(LocalDateTime.now());
        return repository.save(event);
    }

    @Override
    public Event getEventById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public void addComment(Integer id, CommentDto commentDto) {
        Event event = getEventById(id);
        Comment comment = mapper.convertToModel(commentDto);
        event.getComments().add(comment);
        repository.save(event);
    }

    @Override
    public Event addLikeToEvent(Integer id) {
        Event event = getEventById(id);
        event.setLikeCount(event.getLikeCount() + 1);
        Event savedEvent = repository.save(event);
        return savedEvent;
    }
}
