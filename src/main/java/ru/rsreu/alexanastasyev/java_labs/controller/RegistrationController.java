package ru.rsreu.alexanastasyev.java_labs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.alexanastasyev.java_labs.form.RegistrationForm;
import ru.rsreu.alexanastasyev.java_labs.repository.UserRepository;
import ru.rsreu.alexanastasyev.java_labs.util.logger.Logger;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger;
    private final ObjectMapper objectMapper;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder, Logger logger, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.logger = logger;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String registerForm(Model model) {
        logger.info("Showing registration page");
        model.addAttribute("form", new RegistrationForm());
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("form") RegistrationForm form, Errors errors) {
        try {
            logger.info("Registration attempt with params = " + objectMapper.writeValueAsString(form));
        } catch (JsonProcessingException e) {
        }

        if (errors.hasErrors()) {
            logger.warn("Registration failed");
            return "registration";
        }

        userRepository.save(form.toUser(passwordEncoder));
        logger.info("Registration completed successfully. Redirecting to login.");
        return "redirect:/login";
    }
}
