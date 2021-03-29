package com.forbitbd.firebase.model;

public class Police {
    String name;
    String designation;
    String phone;

    public Police() {
    }

    public Police(String name, String designation, String phone) {
        this.name = name;
        this.designation = designation;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
