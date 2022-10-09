package com.school.project.school.project.modelConfig;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository repository){
        return args -> {
            Course course = new Course();
        };

    }


}
