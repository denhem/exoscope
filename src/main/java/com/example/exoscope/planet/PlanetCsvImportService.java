package com.example.exoscope.planet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetCsvImportService {

    private final PlanetRepository planetRepository;

    public PlanetCsvImportService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void importCsv() throws IOException {

        ClassPathResource resource =
                new ClassPathResource("data/planets.csv");

        try (Reader reader = new InputStreamReader(
                resource.getInputStream(),
                StandardCharsets.UTF_8)) {

            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setCommentMarker('#')
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .get();

            try (CSVParser parser = format.parse(reader)) {

                List<Planet> planets = new ArrayList<>();

                for (CSVRecord record : parser) {

                    Planet planet = new Planet();

                    planet.setName(record.get("pl_name"));
                    planet.setHostName(record.get("hostname"));
                    planet.setDiscoveryMethod(
                            record.get("discoverymethod")
                    );
                    planet.setDiscoveryYear(
                            parseInteger(record.get("disc_year"))
                    );
                    planet.setRadius(
                            parseDouble(record.get("pl_rade"))
                    );
                    planet.setMass(
                            parseDouble(record.get("pl_bmasse"))
                    );
                    planet.setOrbitalPeriod(
                            parseDouble(record.get("pl_orbper"))
                    );
                    planet.setDistanceFromEarth(
                            parseDouble(record.get("sy_dist"))
                    );

                    planets.add(planet);
                }

                planetRepository.saveAll(planets);
            }
        }
    }

    private Double parseDouble(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return Double.parseDouble(value.trim());
    }

    private Integer parseInteger(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return Integer.parseInt(value.trim());
    }


}
