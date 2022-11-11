package ru.rsreu.alexanastasyev.java_labs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.alexanastasyev.java_labs.model.Course;
import ru.rsreu.alexanastasyev.java_labs.model.Order;
import ru.rsreu.alexanastasyev.java_labs.repository.CourseRepository;
import ru.rsreu.alexanastasyev.java_labs.repository.OrderRepository;
import ru.rsreu.alexanastasyev.java_labs.util.logger.Logger;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    private final CourseRepository courseRepository;
    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;
    private final Logger logger;

    @Autowired
    public OrderController(CourseRepository courseRepository, OrderRepository orderRepository, ObjectMapper objectMapper, Logger logger) {
        this.courseRepository = courseRepository;
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper;
        this.logger = logger;
    }

    @ModelAttribute
    public void addCoursesToModel(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
    }

    @GetMapping
    public String showOrderForm(Model model) {
        logger.info("Showing order page");
        model.addAttribute("order", (new Order()));
        return "order";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors) {
        try {
            logger.info("Creating order : " + objectMapper.writeValueAsString(order));
        } catch (JsonProcessingException e) {
        }

        if (errors.hasErrors()) {
            logger.warn("Order creating failed");
            return "order";
        }

        orderRepository.save(order);
        logger.info("Order created successfully");
        return "redirect:/";
    }

}
