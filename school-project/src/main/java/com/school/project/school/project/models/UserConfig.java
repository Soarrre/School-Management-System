package com.school.project.school.project.models;

import com.school.project.school.project.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        repository.saveAll(
                List.of(new User())

        );
        return args -> {
            User user = new User();
        };

    }


}
