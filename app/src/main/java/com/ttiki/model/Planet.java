package com.ttiki.model;

import com.google.gson.annotations.SerializedName;

public class Planet {
    // Why did we had to make these attr public?
    // And why do we have to get & set them if we made them public?
    // This doesn't make any sense!
    public int id;
    public String nom;
    public float distance;
    @SerializedName("logo")
    public String imageUrl;

    public Planet(int id, String nom, float distance, String imageUrl) {
        this.id = id;
        this.nom = nom;
        this.distance = distance;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


}


