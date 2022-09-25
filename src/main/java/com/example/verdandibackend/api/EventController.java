package com.example.verdandibackend.api;

import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.service.abstracts.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/events")
@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService service;


    @GetMapping
    public List<Event> listAllEvents(){
        return service.getAll();
    }

    @PostMapping
    public Event add(@RequestBody Event event){
        return service.add(event);
    }
}
