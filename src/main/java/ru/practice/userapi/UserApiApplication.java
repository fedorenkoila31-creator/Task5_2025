package ru.practice.userapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.practice.userapi.model.User;
import ru.practice.userapi.repository.UserRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(UserRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new User("Иван Иванов", "ivan@example.com", LocalDateTime.now()));
                repository.save(new User("Анна Петрова", "anna@example.com", LocalDateTime.now()));
            }
        };
    }
}
