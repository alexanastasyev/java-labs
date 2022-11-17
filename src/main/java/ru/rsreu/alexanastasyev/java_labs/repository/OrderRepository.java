package ru.rsreu.alexanastasyev.java_labs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.rsreu.alexanastasyev.java_labs.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {
}
