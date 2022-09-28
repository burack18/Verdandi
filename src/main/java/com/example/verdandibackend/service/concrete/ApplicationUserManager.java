package com.example.verdandibackend.service.concrete;

import com.example.verdandibackend.api.dto.LoginRequest;
import com.example.verdandibackend.api.dto.RegisterUserDto;
import com.example.verdandibackend.api.dto.UserLoginResponse;
import com.example.verdandibackend.dao.ApplicationUserRepository;
import com.example.verdandibackend.model.ApplicationUser;
import com.example.verdandibackend.model.Document;
import com.example.verdandibackend.security.ApplicationUserPrincipal;
import com.example.verdandibackend.security.JWTTokenProvider;
import com.example.verdandibackend.security.UserPrincipalManager;
import com.example.verdandibackend.service.abstracts.ApplicationUserService;
import com.example.verdandibackend.service.abstracts.DocumentService;
import com.example.verdandibackend.utilities.mapper.ApplicationUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class ApplicationUserManager implements ApplicationUserService {
    private final ApplicationUserRepository repository;
    private final DocumentService documentService;
    private final ApplicationUserMapper mapper;
    private final JWTTokenProvider provider;
    private final AuthenticationManager manager;
    private final UserPrincipalManager userPrincipalManager;
    private final PasswordEncoder encoder;


    @Transactional
    @Override
    public ApplicationUser add(RegisterUserDto applicationUser) throws IOException {
        ApplicationUser user = mapper.convertToModel(applicationUser);
        user.setPassword(encoder.encode(applicationUser.getPassword()));
        ApplicationUser savedUser = repository.saveAndFlush(user);
        Document document = new Document();
        document.setProfileFoto(applicationUser.getProfileFoto().getBytes());
        document.setUser(user);
        documentService.add(document);
        return savedUser;
    }

    @Override
    public UserLoginResponse getById(Integer id) {
        Document byUserId = documentService.getByUserId(id);
        ApplicationUser applicationUser = repository.findById(id).orElseThrow(() -> new RuntimeException());

//        UserLoginResponse response=new UserLoginResponse(applicationUser.getFirstName(),
//                applicationUser.getLastName(),
//                applicationUser.getEmail(),
//                applicationUser.getPhoneNumber(),
//                applicationUser.getBirthDate(),
//                applicationUser.getUserScore(),
//                byUserId.getProfileFoto());
        return new UserLoginResponse();
    }

    @Override
    public UserLoginResponse login(LoginRequest request) {
        UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword());
        Authentication authenticate = manager.authenticate(token);
        ApplicationUserPrincipal userDetails = (ApplicationUserPrincipal) userPrincipalManager.loadUserByUsername(request.getEmail());
        ApplicationUser applicationUser=userDetails.getApplicationUser();
        String generateJwtToken = provider.generateJwtToken(userDetails);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        Document document = documentService.getByUserId(applicationUser.getId());
        return new UserLoginResponse("Bearer "+generateJwtToken,applicationUser.getFirstName(),
                applicationUser.getLastName(),
                applicationUser.getEmail(),
                applicationUser.getPhoneNumber(),
                applicationUser.getBirthDate(),
                applicationUser.getUserScore(),
                document.getProfileFoto()
        );
    }
}
