package com.ttiki.activity3_geoloc.model;

import com.ttiki.activity3_geoloc.adapter.FeaturesItem;

import java.util.List;

public class GeoResponse {
    private List<FeaturesItem> features;
    private String licence;
    private String attribution;
    private int limit;
    private String type;
    private String version;

    public List<FeaturesItem> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeaturesItem> features) {
        this.features = features;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}