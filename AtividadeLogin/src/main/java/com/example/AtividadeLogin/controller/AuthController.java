package com.example.AtividadeLogin.controller;
import com.example.AtividadeLogin.model.UserRegisterDTO;
import com.example.AtividadeLogin.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Tela de login
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    // Tela de registro
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegisterDTO());
        return "register"; // register.html
    }

    // Processa registro
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid UserRegisterDTO userDTO,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        try {
            authService.registerUser(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
        } catch (IllegalArgumentException e) {
            model.addAttribute("registrationError", e.getMessage());
            return "register";
        }

        return "redirect:/login?registered";
    }

    // Logout via botão “Sair”
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout(); // invalida sessão
        return "redirect:/login?logout";
    }
}
