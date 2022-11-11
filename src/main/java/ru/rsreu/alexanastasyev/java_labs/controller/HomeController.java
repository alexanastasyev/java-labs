package ru.rsreu.alexanastasyev.java_labs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.rsreu.alexanastasyev.java_labs.util.logger.Logger;

@Controller
public class HomeController {

    private final Logger logger;

    @Autowired
    public HomeController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/")
    public String home() {
        logger.info("Showing home page");
        return "home";
    }

}
