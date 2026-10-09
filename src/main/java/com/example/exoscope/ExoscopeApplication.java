package com.example.exoscope;

import com.example.exoscope.planet.PlanetCsvImportService;
import com.example.exoscope.planet.PlanetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExoscopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExoscopeApplication.class, args);
	}

    @Bean
    CommandLineRunner importPlanets(
            PlanetCsvImportService importService,
            PlanetRepository planetRepository) {

        return args -> {
            if (planetRepository.count() == 0) {
                importService.importCsv();
            }
        };
    }
}
