package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.dao.EventRepository;
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
}
