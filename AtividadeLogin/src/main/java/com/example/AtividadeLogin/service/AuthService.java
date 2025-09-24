package com.example.AtividadeLogin.service;

import com.example.AtividadeLogin.model.User;
import com.example.AtividadeLogin.repository.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * Serviço de autenticação e cadastro.
 * Registra usuários e admins, e fornece busca por email.
 */
@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository repo, PasswordEncoder encoder) {
        this.authRepository = repo;
        this.passwordEncoder = encoder;
    }

    /**
     * Registra um usuário comum.
     */
    public User registerUser(String username, String email, String password) {
        return register(username, email, password, Collections.singleton("ROLE_USER"));
    }

    /**
     * Registra um administrador.
     */
    public User registerAdmin(String username, String email, String password) {
        return register(username, email, password, Collections.singleton("ROLE_ADMIN"));
    }

    /**
     * Lógica interna de cadastro
     */
    private User register(String username, String email, String password, Set<String> roles) {
        if (authRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);

        return authRepository.save(user);
    }

    /**
     * Busca usuário por email
     */
    public User findByEmail(String email) {
        return authRepository.findByEmail(email).orElse(null);
    }
    
}
