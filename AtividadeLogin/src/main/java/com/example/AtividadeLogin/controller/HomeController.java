package com.example.AtividadeLogin.controller;

import com.example.AtividadeLogin.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        model.addAttribute("name", userDetails.getDisplayName());

        // Redireciona para dashboards diferentes dependendo da role
        boolean isAdmin = userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            return "admin-dashboard"; // admin-dashboard.html
        } else {
            return "user-dashboard";  // user-dashboard.html
        }
    }
}
