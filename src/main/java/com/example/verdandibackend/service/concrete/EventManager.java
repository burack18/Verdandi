package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.dao.EventRepository;
import com.example.verdandibackend.model.Comment;
import com.example.verdandibackend.model.Event;
import com.example.verdandibackend.model.enums.ReactionType;
import com.example.verdandibackend.service.abstracts.CommentService;
import com.example.verdandibackend.service.abstracts.EventService;
import com.example.verdandibackend.service.abstracts.ReactionService;
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
    private final CommentService commentService;
    private final ReactionService reactionService;

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
    public Comment addComment(Integer id, CommentDto commentDto) {
        Event event = getEventById(id);
        Comment comment = mapper.convertToModel(commentDto);
        comment.setCreateTime(LocalDateTime.now());
        comment.setEvent(event);
        Comment savedComment = commentService.add(comment);
        return savedComment;
    }

    @Override
    public Event addLikeToEvent(Integer id) {
        Event event = getEventById(id);
//        Long likeCount = event.getLikeCount();
//        event.setLikeCount((likeCount==null?0:likeCount) + 1);
        Event savedEvent = repository.save(event);
        return savedEvent;
    }

    @Override
    public void deleteById(Integer id) {
        Event eventById = getEventById(id);
        repository.deleteById(id);
    }

    @Override
    public Integer getCountOfReaction(Integer id, ReactionType type) {
        return reactionService.getAllByEvent_IdAndReactionType(id,type);
    }
}
