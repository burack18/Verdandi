package com.example.verdandibackend.api;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.model.enums.ReactionType;
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

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEvent(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.ok("successfull");
    }

    @PutMapping("/{id}/reactions")
    public ResponseEntity addLikeToEvent(@PathVariable Integer id,@RequestBody ReactionType type){
        service.addLikeToEvent(id,type);
        return ResponseEntity.ok("successfull");
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity addCommentToEvent(@PathVariable Integer id, @RequestBody CommentDto commentDto){
        return ResponseEntity.ok(service.addComment(id,commentDto));
    }

    @GetMapping("/{id}/reactions")
    public ResponseEntity getReactions(@PathVariable Integer id, @RequestParam ReactionType type){
        return ResponseEntity.ok(service.getCountOfReaction(id,type));
    }
    @PutMapping("/{id}/comments/{commentid}/reactions")
    public ResponseEntity addLike(@PathVariable Integer commentid,@RequestBody ReactionType type){
        commentService.addReactionToComment(commentid,type);
        return ResponseEntity.ok("successfull");
    }
}
