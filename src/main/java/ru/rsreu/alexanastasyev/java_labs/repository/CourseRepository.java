package ru.rsreu.alexanastasyev.java_labs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.rsreu.alexanastasyev.java_labs.model.Course;

public interface CourseRepository extends MongoRepository<Course, Integer> {
}
