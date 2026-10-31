package com.nadia.entreprise;

import com.nadia.entreprise.entities.Entreprise;
import com.nadia.entreprise.repos.EntrepriseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntrepriseMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrepriseMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EntrepriseRepository entrepriseRepository) {
        return args -> {
            entrepriseRepository.save(Entreprise.builder()
                    .nomEnt("Info Tech")
                    .codeEnt("IT")
                    .build());
            entrepriseRepository.save(Entreprise.builder()
                    .nomEnt("Marketing")
                    .codeEnt("MK")
                    .build());
        };
    }
}