package com.ttiki.planets.model;

public class PlanetInfo {
    private String seemore;
    private String name;
    private String description;
    private String logo;
    private int id;
    private int planetId;
    private float distance;

    public float getDist() {
        return distance;
    }

    public void setDist(float dist) {
        this.distance = dist;
    }

    public String getSeemore() {
        return seemore;
    }

    public void setSeemore(String seemore) {
        this.seemore = seemore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlanetId() {
        return planetId;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }
}
