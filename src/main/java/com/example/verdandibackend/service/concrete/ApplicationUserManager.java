package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.api.dto.LoginRequest;
import com.example.verdandibackend.api.dto.RegisterUserDto;
import com.example.verdandibackend.api.dto.UserLoginResponse;
import com.example.verdandibackend.dao.ApplicationUserRepository;
import com.example.verdandibackend.model.ApplicationUser;
import com.example.verdandibackend.model.Document;
import com.example.verdandibackend.service.abstracts.ApplicationUserService;
import com.example.verdandibackend.service.abstracts.DocumentService;
import com.example.verdandibackend.utilities.mapper.ApplicationUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ApplicationUserManager implements ApplicationUserService {
    private final ApplicationUserRepository repository;
    private final DocumentService documentService;
    private final ApplicationUserMapper mapper;


    @Transactional
    @Override
    public ApplicationUser add(RegisterUserDto applicationUser) throws IOException {
        ApplicationUser user = mapper.convertToModel(applicationUser);
        ApplicationUser savedUser = repository.saveAndFlush(user);
        Document document = new Document();
        document.setProfileFoto(applicationUser.getFoto().getBytes());
        document.setUser(user);
        documentService.add(document);
        return savedUser;
    }

    @Override
    public UserLoginResponse getById(Integer id) {
        Document byUserId = documentService.getByUserId(id);
        ApplicationUser applicationUser = repository.findById(id).orElseThrow(() -> new RuntimeException());

        UserLoginResponse response=new UserLoginResponse(applicationUser.getFirstName(),
                applicationUser.getLastName(),
                applicationUser.getEmail(),
                applicationUser.getPhoneNumber(),
                applicationUser.getBirthDate(),
                applicationUser.getUserScore(),
                byUserId.getProfileFoto());
        return response;
    }

    @Override
    public void login(LoginRequest request) {

    }
}
