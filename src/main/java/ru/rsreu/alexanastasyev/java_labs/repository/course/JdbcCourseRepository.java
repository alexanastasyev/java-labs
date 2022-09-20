package ru.rsreu.alexanastasyev.java_labs.repository.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.rsreu.alexanastasyev.java_labs.model.Course;
import ru.rsreu.alexanastasyev.java_labs.model.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCourseRepository implements CourseRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcCourseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Course> findAll() {
        return jdbc.query(
                "SELECT courses.id, courses.title, languages.name AS language\n" +
                        "FROM courses INNER JOIN languages ON courses.language_id = languages.id\n" +
                        "ORDER BY courses.id",
                this::mapRowToCourse);
    }

    @Override
    public Course findByName(String name) {
        return jdbc.queryForObject(
                "SELECT courses.id, courses.title, languages.name AS language\n" +
                        "FROM courses INNER JOIN languages ON courses.language_id = languages.id\n" +
                        "WHERE courses.title = ?",
                this::mapRowToCourse,
                name);
    }

    private Course mapRowToCourse(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Course(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                Language.valueOf(resultSet.getString("language").toUpperCase())
        );
    }

}
