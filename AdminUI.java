package com.cabbooking.ui;

import com.cabbooking.model.Cab;
import com.cabbooking.model.Driver;
import com.cabbooking.service.CabService;
import com.cabbooking.service.DriverService;
import com.cabbooking.service.TripBookingService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI {
    private DriverService driverService = new DriverService();
    private CabService cabService = new CabService();
    private TripBookingService tripBookingService = new TripBookingService();

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Admin Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton registerDriverButton = new JButton("Register Driver");
        registerDriverButton.setBounds(10, 20, 160, 25);
        panel.add(registerDriverButton);

        JButton listDriversButton = new JButton("List Drivers");
        listDriversButton.setBounds(200, 20, 160, 25);
        panel.add(listDriversButton);

        JButton registerCabButton = new JButton("Register Cab");
        registerCabButton.setBounds(10, 60, 160, 25);
        panel.add(registerCabButton);

        JButton listCabsButton = new JButton("List Cabs");
        listCabsButton.setBounds(200, 60, 160, 25);
        panel.add(listCabsButton);

        JButton bookTripButton = new JButton("Book Trip");
        bookTripButton.setBounds(10, 100, 160, 25);
        panel.add(bookTripButton);

        JButton listTripsButton = new JButton("List Trips");
        listTripsButton.setBounds(200, 100, 160, 25);
        panel.add(listTripsButton);

        registerDriverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter driver name:");
                String license = JOptionPane.showInputDialog("Enter license number:");

                driverService.registerDriver(new Driver(0, name, license, null));
                JOptionPane.showMessageDialog(panel, "Driver registered!");
            }
        });

        listDriversButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                driverService.listDrivers();
            }
        });

        registerCabButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String model = JOptionPane.showInputDialog("Enter cab model:");
                String regNumber = JOptionPane.showInputDialog("Enter registration number:");

                cabService.registerCab(new Cab(0, model, regNumber));
                JOptionPane.showMessageDialog(panel, "Cab registered!");
            }
        });

        listCabsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cabService.listCabs();
            }
        });

        bookTripButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to book a trip
                JOptionPane.showMessageDialog(panel, "Trip booked!");
            }
        });

        listTripsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tripBookingService.listTrips();
            }
        });
    }
}
