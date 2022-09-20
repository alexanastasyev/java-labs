package ru.rsreu.alexanastasyev.java_labs.controller;

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
import ru.rsreu.alexanastasyev.java_labs.repository.course.CourseRepository;
import ru.rsreu.alexanastasyev.java_labs.repository.order.OrderRepository;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    private final CourseRepository courseRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(CourseRepository courseRepository, OrderRepository orderRepository) {
        this.courseRepository = courseRepository;
        this.orderRepository = orderRepository;
    }

    @ModelAttribute
    public void addCoursesToModel(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
    }

    @GetMapping
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "order";
        }
        orderRepository.save(order);
        return "redirect:/";
    }

}
