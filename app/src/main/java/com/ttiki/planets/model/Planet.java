package com.ttiki.planets.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "planet")
public class Planet {
    @ColumnInfo(name = "nom")
    public String nom;
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "distance")
    public float distance;
    @ColumnInfo(name = "logo")
    @SerializedName("logo")
    public String imageUrl;

    public Planet(String nom, int id, float distance, String imageUrl) {
        this.nom = nom;
        this.id = id;
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


