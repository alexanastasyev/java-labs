package ru.rsreu.alexanastasyev.java_labs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import ru.rsreu.alexanastasyev.java_labs.model.Course;
import ru.rsreu.alexanastasyev.java_labs.model.Language;
import ru.rsreu.alexanastasyev.java_labs.repository.CourseRepository;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class JavaLabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLabsApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CourseRepository courseRepository) {
        return args -> {
            courseRepository.save(new Course(-1, "English basics", Language.ENGLISH));
            courseRepository.save(new Course(-1, "English grammar", Language.ENGLISH));
            courseRepository.save(new Course(-1, "English vocabulary", Language.ENGLISH));

            courseRepository.save(new Course(-1, "German basics", Language.GERMAN));
            courseRepository.save(new Course(-1, "German grammar", Language.GERMAN));
            courseRepository.save(new Course(-1, "German vocabulary", Language.GERMAN));

            courseRepository.save(new Course(-1, "French basics", Language.FRENCH));
            courseRepository.save(new Course(-1, "French grammar", Language.FRENCH));
            courseRepository.save(new Course(-1, "French vocabulary", Language.FRENCH));
        };
    }

}
