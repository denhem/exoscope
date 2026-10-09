package com.example.exoscope.planet;

import jakarta.persistence.*;

@Entity
@Table(name = "exoplanets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private String hostName;
    private String discoveryMethod;
    private Integer discoveryYear;
    private Double radius;
    private Double mass;
    private Double orbitalPeriod;
    private Double distanceFromEarth;

    public Planet() {

    }

    public Double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(Double distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Integer getDiscoveryYear() {
        return discoveryYear;
    }

    public void setDiscoveryYear(Integer discoveryYear) {
        this.discoveryYear = discoveryYear;
    }

    public String getDiscoveryMethod() {
        return discoveryMethod;
    }

    public void setDiscoveryMethod(String discoveryMethod) {
        this.discoveryMethod = discoveryMethod;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
