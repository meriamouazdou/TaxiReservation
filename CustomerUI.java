package com.cabbooking.ui;

import com.cabbooking.model.Driver;
import com.cabbooking.service.DriverService;
import com.cabbooking.service.TripBookingService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerUI {
    private String userName;
    private DriverService driverService;
    private TripBookingService tripBookingService;

    public CustomerUI(String userName) {
        this.userName = userName;
        this.driverService = new DriverService();
        this.tripBookingService = new TripBookingService();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Customer - " + userName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel startLocationLabel = new JLabel("Start Location:");
        startLocationLabel.setBounds(10, 20, 100, 25);
        panel.add(startLocationLabel);

        JTextField startLocationText = new JTextField(20);
        startLocationText.setBounds(150, 20, 165, 25);
        panel.add(startLocationText);

        JLabel endLocationLabel = new JLabel("End Location:");
        endLocationLabel.setBounds(10, 50, 100, 25);
        panel.add(endLocationLabel);

        JTextField endLocationText = new JTextField(20);
        endLocationText.setBounds(150, 50, 165, 25);
        panel.add(endLocationText);

        JTextArea availableDriversText = new JTextArea();
        availableDriversText.setBounds(10, 110, 360, 150);
        availableDriversText.setEditable(false);
        panel.add(availableDriversText);

        JButton showDriversButton = new JButton("Show Available Drivers");
        showDriversButton.setBounds(10, 80, 200, 25);
        panel.add(showDriversButton);

        JButton bookButton = new JButton("Book Driver");
        bookButton.setBounds(220, 80, 150, 25);
        bookButton.setEnabled(false);
        panel.add(bookButton);

        showDriversButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startLocation = startLocationText.getText();
                String endLocation = endLocationText.getText();

                List<Driver> availableDrivers = driverService.getAvailableDrivers();
                StringBuilder driversInfo = new StringBuilder("Available Drivers:\n");

                for (Driver driver : availableDrivers) {
                    double price = driverService.getDriverPrice(driver, startLocation, endLocation);
                    driversInfo.append(driver.getName())
                            .append(" - License: ")
                            .append(driver.getLicense())
                            .append(" - Price: $")
                            .append(price)
                            .append("\n");
                }

                availableDriversText.setText(driversInfo.toString());
                bookButton.setEnabled(true); // Enable the book button after showing drivers
            }
        });

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startLocation = startLocationText.getText();
                String endLocation = endLocationText.getText();

                List<Driver> availableDrivers = driverService.getAvailableDrivers();
                if (!availableDrivers.isEmpty()) {
                    Driver selectedDriver = availableDrivers.get(0); // Here we are just picking the first driver for simplicity
                    tripBookingService.bookTrip(userName, selectedDriver, startLocation, endLocation);
                    JOptionPane.showMessageDialog(panel, "Trip booked with driver " + selectedDriver.getName());
                } else {
                    JOptionPane.showMessageDialog(panel, "No drivers available to book.");
                }
            }
        });
    }
}
