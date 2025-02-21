package com.example.CulturalBajzelPage.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @GetMapping("/login")
    public String showLoginForm(Model model, @RequestParam(required = false) String error) {
        model.addAttribute("error", error);
        return "login";
    }
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
}
