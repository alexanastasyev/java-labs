package ru.rsreu.alexanastasyev.java_labs.repository.order;

import ru.rsreu.alexanastasyev.java_labs.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
