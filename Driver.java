package com.cabbooking.model;

public class Driver {
    private int id;
    private String name;
    private String license;
    private String phone;
    private boolean available;
    private String location; // Add location attribute

    public Driver(int id, String name, String license, String phone) {
        this.id = id;
        this.name = name;
        this.license = license;
        this.phone = phone;
        this.available = true; // Par défaut, le chauffeur est disponible
        this.location = "Unknown"; // Default location
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
