package com.nadia.employes;

import com.nadia.employes.entities.Employe;
import com.nadia.employes.repos.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeRepository employeRepository) {
        return args -> {
            employeRepository.save(Employe.builder()
                    .prenom("Nadia")
                    .nom("Limam")
                    .build());
        };
    }
}