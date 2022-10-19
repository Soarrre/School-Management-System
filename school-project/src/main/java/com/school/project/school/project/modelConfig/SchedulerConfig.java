package com.school.project.school.project.modelConfig;

import com.school.project.school.project.models.Scheduler;
import com.school.project.school.project.repository.SchedulerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    CommandLineRunner commandLineRunner(SchedulerRepository repository){
        return args -> {
            Scheduler scheduler = new Scheduler();
        };
    }

}
