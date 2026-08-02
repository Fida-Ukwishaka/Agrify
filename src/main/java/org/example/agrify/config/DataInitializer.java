package org.example.agrify.config;

import lombok.RequiredArgsConstructor;
import org.example.agrify.entity.Farm;
import org.example.agrify.entity.Worker;
import org.example.agrify.enums.Role;
import org.example.agrify.repository.FarmRepository;
import org.example.agrify.repository.WorkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final WorkerRepository workerRepository;

    private final FarmRepository farmRepository;

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initializeData() {

        return args -> {

            if (workerRepository.count() == 0) {

                Farm farm = Farm.builder()

                        .farmName("Agrify Farm")

                        .location("Accra")

                        .farmSize(BigDecimal.valueOf(120))

                        .ownerName("Administrator")

                        .build();

                farmRepository.save(farm);

                Worker admin = Worker.builder()

                        .firstName("System")

                        .lastName("Administrator")

                        .email("admin@agrify.com")

                        .password(passwordEncoder.encode("admin123"))

                        .phoneNumber("0200000000")

                        .salary(BigDecimal.ZERO)

                        .role(Role.ADMIN)

                        .approved(true)

                        .farm(farm)

                        .build();

                workerRepository.save(admin);

            }

        };
    }
}