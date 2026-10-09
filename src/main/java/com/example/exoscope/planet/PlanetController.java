package com.example.exoscope.planet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public List<Planet> getPlanets() {
        return planetService.getPlanets();
    }

    @GetMapping("/{id}")
    public Planet getPlanetById(@PathVariable Long id){
        return planetService.getPlanetById(id);
    }

}
