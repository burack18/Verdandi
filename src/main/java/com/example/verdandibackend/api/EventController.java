package com.example.verdandibackend.api;

import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.service.abstracts.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity getEventById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getEventById(id));
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity addCommentToEvent(@PathVariable Integer id, @RequestBody Comment comment){
        service.addComment(id,comment);
        return ResponseEntity.ok("successfull");
    }

}
