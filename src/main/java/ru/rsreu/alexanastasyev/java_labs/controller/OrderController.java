package ru.rsreu.alexanastasyev.java_labs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.rsreu.alexanastasyev.java_labs.model.Course;
import ru.rsreu.alexanastasyev.java_labs.model.Order;
import ru.rsreu.alexanastasyev.java_labs.repository.CourseRepository;
import ru.rsreu.alexanastasyev.java_labs.repository.OrderRepository;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private final CourseRepository courseRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(CourseRepository courseRepository, OrderRepository orderRepository) {
        this.courseRepository = courseRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Order> processOrder(@Valid @RequestBody Order order, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

}
