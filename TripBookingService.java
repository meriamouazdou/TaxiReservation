package com.cabbooking.service;

import com.cabbooking.model.Driver;
import com.cabbooking.model.TripBooking;
import com.cabbooking.repository.TripBookingRepository;

import java.util.List;

public class TripBookingService {
    private TripBookingRepository tripBookingRepository = new TripBookingRepository();

    public void bookTrip(TripBooking tripBooking) {
        tripBookingRepository.save(tripBooking);
    }

    public List<TripBooking> listTrips() {
        return tripBookingRepository.findAll();
    }
    public TripBookingService() {
        this.tripBookingRepository = new TripBookingRepository();
    }

    public void bookTrip(String customerName, Driver driver, String startLocation, String endLocation) {
        TripBooking tripBooking = new TripBooking(driver, startLocation, endLocation);
        tripBookingRepository.addTripBooking(tripBooking);
        driver.setAvailable(false); // Set the driver as unavailable after booking
    }
}
