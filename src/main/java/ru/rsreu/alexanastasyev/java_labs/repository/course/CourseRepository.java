package ru.rsreu.alexanastasyev.java_labs.repository.course;

import ru.rsreu.alexanastasyev.java_labs.model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAll();
    Course findByName(String name);
}
