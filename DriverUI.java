package com.cabbooking.ui;

import com.cabbooking.model.Driver;
import com.cabbooking.service.DriverService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverUI {
    private String userName;
    private DriverService driverService;

    public DriverUI(String userName) {
        this.userName = userName;
        this.driverService = new DriverService();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Driver - " + userName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel driverInfoLabel = new JLabel("Driver Info:");
        driverInfoLabel.setBounds(10, 20, 80, 25);
        panel.add(driverInfoLabel);

        JTextArea driverInfoText = new JTextArea();
        driverInfoText.setBounds(100, 20, 250, 75);
        driverInfoText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(driverInfoText);
        scrollPane.setBounds(100, 20, 250, 75);
        panel.add(scrollPane);

        JButton updateLocationButton = new JButton("Update Location");
        updateLocationButton.setBounds(10, 100, 150, 25);
        panel.add(updateLocationButton);

        JButton toggleAvailabilityButton = new JButton("Toggle Availability");
        toggleAvailabilityButton.setBounds(10, 130, 150, 25);
        panel.add(toggleAvailabilityButton);

        JButton showTripsButton = new JButton("Show Trips");
        showTripsButton.setBounds(10, 160, 150, 25);
        panel.add(showTripsButton);

        updateLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newLocation = JOptionPane.showInputDialog(panel, "Enter new location:");
                if (newLocation != null && !newLocation.isEmpty()) {
                    driverService.updateDriverLocation(userName, newLocation);
                    JOptionPane.showMessageDialog(panel, "Location updated successfully!");
                }
            }
        });

        toggleAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverService.toggleDriverAvailability(userName);
                JOptionPane.showMessageDialog(panel, "Availability toggled successfully!");
            }
        });

        showTripsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tripsInfo = driverService.getTripsInfo(userName);
                JOptionPane.showMessageDialog(panel, tripsInfo);
            }
        });

        // Set initial driver info
        Driver driver = driverService.getDriverByName(userName);
        if (driver != null) {
            driverInfoText.setText("Name: " + driver.getName() + "\n"
                    + "License: " + driver.getLicense() + "\n"
                    + "Phone: " + driver.getPhone() + "\n"
                    + "Available: " + driver.isAvailable());
        }
    }
}
