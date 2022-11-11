package ru.rsreu.alexanastasyev.java_labs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.rsreu.alexanastasyev.java_labs.util.logger.Logger;

@Controller
public class LoginController {

    private final Logger logger;

    @Autowired
    public LoginController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/login")
    public String login() {
        logger.info("Showing login page");
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        logger.warn("Login failed. Showing login page with errors");
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }

}
