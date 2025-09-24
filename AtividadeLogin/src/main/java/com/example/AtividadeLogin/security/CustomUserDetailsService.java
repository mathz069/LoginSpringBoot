package com.example.AtividadeLogin.security;

import com.example.AtividadeLogin.model.User;
import com.example.AtividadeLogin.repository.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    public CustomUserDetailsService(AuthRepository repo) {
        this.authRepository = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = authRepository.findByEmail(email)
                      .orElseThrow(() -> new UsernameNotFoundException("Email não encontrado"));
        return new CustomUserDetails(user);
    }
}
