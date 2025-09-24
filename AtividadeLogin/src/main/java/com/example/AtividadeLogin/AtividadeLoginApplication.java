package com.example.AtividadeLogin;

import com.example.AtividadeLogin.service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AtividadeLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtividadeLoginApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AuthService authService) {
        return args -> {
            try {
                authService.registerAdmin("Administrador", "admin@teste.com", "admin123");
                System.out.println("Admin criado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Admin já existe.");
            }
        };
    }
}
