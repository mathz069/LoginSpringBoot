package com.example.AtividadeLogin.repository;

import com.example.AtividadeLogin.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/**
 * Repositório único para todos os usuários (usuários e admins)
 */
public interface AuthRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}