package ru.rsreu.alexanastasyev.java_labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.alexanastasyev.java_labs.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
