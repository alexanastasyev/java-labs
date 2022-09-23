package ru.rsreu.alexanastasyev.java_labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.alexanastasyev.java_labs.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
