package com.example.verdandibackend.security;

import com.example.verdandibackend.dao.ApplicationUserRepository;
import com.example.verdandibackend.model.ApplicationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPrincipalManager implements UserDetailsService {

    private final ApplicationUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<ApplicationUser> user=repository.findByEmail(email);

        ApplicationUserPrincipal userPrincipal=new ApplicationUserPrincipal(user.orElseThrow(()->new UsernameNotFoundException("notfound")));
        return userPrincipal;
    }
}