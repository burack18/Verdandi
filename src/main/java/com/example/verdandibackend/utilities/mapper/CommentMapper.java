package com.example.verdandibackend.utilities.mapper;

import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.model.Comment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class CommentMapper {

    private final ModelMapper mapper;

    public CommentDto convertToDto(Comment comment) {
        return mapper.map(comment,CommentDto.class);
    }
    public Comment convertToModel(CommentDto commentDto) {
        return mapper.map(commentDto,Comment.class);
    }



}
