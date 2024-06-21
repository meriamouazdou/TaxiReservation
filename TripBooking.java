package com.cabbooking.model;

public class TripBooking {
    private Driver driver;
    private String startLocation;
    private String endLocation;
    private boolean completed;

    public TripBooking(Driver driver, String startLocation, String endLocation) {
        this.driver = driver;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.completed = false;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Trip from " + startLocation + " to " + endLocation + " with driver " + driver.getName() + " - " + (completed ? "Completed" : "Pending");
    }
}
