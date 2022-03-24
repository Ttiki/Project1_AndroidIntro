package com.ttiki.mynamemycountry.model;

public class Country {
    String name;
    Double proba;

    public Country(String name, Double proba) {
        this.name = name;
        this.proba = proba;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProba() {
        return proba;
    }

    public void setProba(Double proba) {
        this.proba = proba;
    }
}
