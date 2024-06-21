package com.cabbooking.service;

import com.cabbooking.model.Driver;
import com.cabbooking.model.TripBooking;
import com.cabbooking.repository.DriverRepository;
import com.cabbooking.repository.TripBookingRepository;

import java.util.List;

public class DriverService {
    private DriverRepository driverRepository;
    private TripBookingRepository tripBookingRepository;

    public DriverService() {
        this.driverRepository = new DriverRepository();
        this.tripBookingRepository = new TripBookingRepository();
    }

    public Driver findDriverByName(String name) {
        return driverRepository.findDriverByName(name);
    }

    public List<Driver> getAvailableDrivers() {
        return driverRepository.getAvailableDrivers();
    }

    public double getDriverPrice(Driver driver, String startLocation, String endLocation) {
        return tripBookingRepository.calculatePrice(driver, startLocation, endLocation);
    }

    public List<TripBooking> getDriverTrips(Driver driver) {
        return tripBookingRepository.findByDriver(driver);
    }

    public void markTripComplete(TripBooking tripBooking) {
        tripBookingRepository.markTripComplete(tripBooking);
    }

    public void registerDriver(Driver driver) {
        driverRepository.registerDriver(driver);
    }

    public List<Driver> listDrivers() {
        return driverRepository.listDrivers();
    }

    public void updateDriverLocation(String driverName, String newLocation) {
        Driver driver = driverRepository.findDriverByName(driverName);
        if (driver != null) {
            driver.setLocation(newLocation);
            driverRepository.updateDriver(driver);
        }
    }

    public void toggleDriverAvailability(String driverName) {
        Driver driver = driverRepository.findDriverByName(driverName);
        if (driver != null) {
            driver.setAvailable(!driver.isAvailable());
            driverRepository.updateDriver(driver);
        }
    }

    public String getTripsInfo(String driverName) {
        Driver driver = driverRepository.findDriverByName(driverName);
        if (driver != null) {
            List<TripBooking> trips = tripBookingRepository.findByDriver(driver);
            StringBuilder tripsInfo = new StringBuilder("Trips for " + driverName + ":\n");
            for (TripBooking trip : trips) {
                tripsInfo.append(trip.toString()).append("\n");
            }
            return tripsInfo.toString();
        }
        return "No trips found for driver: " + driverName;
    }

    public Driver getDriverByName(String driverName) {
        return driverRepository.findDriverByName(driverName);
    }
}
