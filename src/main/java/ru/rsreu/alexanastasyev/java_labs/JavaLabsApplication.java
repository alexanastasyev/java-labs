package ru.rsreu.alexanastasyev.java_labs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.alexanastasyev.java_labs.model.Course;
import ru.rsreu.alexanastasyev.java_labs.model.Language;
import ru.rsreu.alexanastasyev.java_labs.model.User;
import ru.rsreu.alexanastasyev.java_labs.repository.CourseRepository;
import ru.rsreu.alexanastasyev.java_labs.repository.UserRepository;

@SpringBootApplication
public class JavaLabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLabsApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CourseRepository courseRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
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

            userRepository.save(new User("user", passwordEncoder.encode("user")));
        };
    }

}
