package com.cabbooking.model;

public class Cab {
    private int id;
    private String model;
    private String registrationNumber;
    
    public Cab(int id, String model, String registrationNumber) {
        this.id = id;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
