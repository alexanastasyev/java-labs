package ru.rsreu.alexanastasyev.java_labs.repository.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.rsreu.alexanastasyev.java_labs.model.Order;
import ru.rsreu.alexanastasyev.java_labs.repository.course.CourseRepository;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private final JdbcTemplate jdbc;
    private final CourseRepository courseRepository;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc, CourseRepository courseRepository) {
        this.jdbc = jdbc;
        this.courseRepository = courseRepository;
    }

    @Override
    public Order save(Order order) {
        jdbc.update(
                "INSERT INTO orders(course_id, username, credit_card_number, credit_card_expiration, credit_card_cvv) " +
                        "VALUES (?, ?, ?, ?, ?)",
                findCourseIdByName(order.getCourse()),
                order.getUserName(),
                order.getCreditCardNumber(),
                order.getCreditCardExpiration(),
                order.getCreditCardCVV());
        return order;
    }

    private int findCourseIdByName(String courseName) {
        return courseRepository.findByName(courseName).getId();
    }

}
