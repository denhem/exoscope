package com.example.exoscope.planet;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }


    public List<Planet> getPlanets(){
        return planetRepository.findAll();
    }

    public Planet getPlanetById(Long id){ return planetRepository.findById(id).get();}

    public Optional<Planet> getPlanetByName(String name){ return planetRepository.findByName(name);}

}
