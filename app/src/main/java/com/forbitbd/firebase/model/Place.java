package com.forbitbd.firebase.model;

public class Place {

    String image, name, description, address, dfc;

    public Place() {
    }


    public Place(String image, String name, String description, String address, String dfc) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.address = address;
        this.dfc = dfc;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDfc() {
        return dfc;
    }

    public void setDfc(String dfc) {
        this.dfc = dfc;
    }
}
