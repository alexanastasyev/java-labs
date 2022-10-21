package ru.rsreu.alexanastasyev.java_labs.controller;

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

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("form", new RegistrationForm());
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("form") RegistrationForm form, Errors errors) {
        if (errors.hasErrors()) {
            return "registration";
        }
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
