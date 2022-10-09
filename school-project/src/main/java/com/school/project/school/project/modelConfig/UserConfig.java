package com.school.project.school.project.modelConfig;

import com.school.project.school.project.models.User;
import com.school.project.school.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User user = new User();
        };

    }


}
