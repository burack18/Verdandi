package com.example.verdandibackend.api;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.service.abstracts.CommentService;
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
    private final CommentService commentService;


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
    @GetMapping("/{id}/like")
    public ResponseEntity addLikeToEvent(@PathVariable Integer id){
        return ResponseEntity.ok(service.addLikeToEvent(id));
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity addCommentToEvent(@PathVariable Integer id, @RequestBody CommentDto commentDto){
        service.addComment(id,commentDto);
        return ResponseEntity.ok("successfull");
    }
    @PostMapping("/{id}/comments/{commentid}/like")
    public ResponseEntity addLike(@PathVariable Integer commentid){
        commentService.addLikeToComment(commentid);
        return ResponseEntity.ok("successfull");
    }

}
