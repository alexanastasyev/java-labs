package ru.rsreu.alexanastasyev.java_labs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.rsreu.alexanastasyev.java_labs.model.Course;
import ru.rsreu.alexanastasyev.java_labs.model.Language;
import ru.rsreu.alexanastasyev.java_labs.repository.CourseRepository;

@SpringBootApplication
public class JavaLabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLabsApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CourseRepository courseRepository) {
        return args -> {
            courseRepository.save(new Course("English basics", Language.ENGLISH));
            courseRepository.save(new Course("English grammar", Language.ENGLISH));
            courseRepository.save(new Course("English vocabulary", Language.ENGLISH));

            courseRepository.save(new Course("German basics", Language.GERMAN));
            courseRepository.save(new Course("German grammar", Language.GERMAN));
            courseRepository.save(new Course("German vocabulary", Language.GERMAN));

            courseRepository.save(new Course("French basics", Language.FRENCH));
            courseRepository.save(new Course("French grammar", Language.FRENCH));
            courseRepository.save(new Course("French vocabulary", Language.FRENCH));
        };
    }

}
