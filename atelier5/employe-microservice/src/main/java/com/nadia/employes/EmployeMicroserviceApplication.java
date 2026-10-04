package com.nadia.employes;

import com.nadia.employes.entities.Employe;
import com.nadia.employes.repos.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeMicroserviceApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeRepository employeRepository) {
        return args -> {
            employeRepository.save(Employe.builder()
                    .prenom("Nadia")
                    .nom("Limam")
                    .codeEnt("IT")
                    .build());
        };
    }
}