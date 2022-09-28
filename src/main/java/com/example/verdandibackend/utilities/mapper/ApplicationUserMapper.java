package com.example.verdandibackend.utilities.mapper;

import com.example.verdandibackend.api.dto.ApplicationUserDto;
import com.example.verdandibackend.api.dto.CommentDto;
import com.example.verdandibackend.api.dto.RegisterUserDto;
import com.example.verdandibackend.model.ApplicationUser;
import com.example.verdandibackend.model.Comment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class ApplicationUserMapper {
    private final ModelMapper mapper;

    public ApplicationUserDto convertToDto(ApplicationUser user) {
        return mapper.map(user, ApplicationUserDto.class);
    }
    public ApplicationUser convertToModel(RegisterUserDto userDto) {
        return mapper.map(userDto,ApplicationUser.class);
    }


}
