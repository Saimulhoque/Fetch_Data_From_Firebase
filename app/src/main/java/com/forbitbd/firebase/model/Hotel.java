package com.forbitbd.firebase.model;

public class Hotel {

    String image, name, description,location,time;

    public Hotel() {
    }


    public Hotel(String image, String name, String description, String location, String time) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.location = location;
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
