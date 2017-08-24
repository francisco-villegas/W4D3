package com.example.francisco.w4d3.model;

/**
 * Created by FRANCISCO on 23/08/2017.
 */

public class Dishes {
    String name, region, type, url, description;

    public Dishes(String name, String region, String type, String url, String description) {
        this.name = name;
        this.region = region;
        this.type = type;
        this.url = url;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
