package com.cabbooking.ui;

import javax.swing.*;

public class MainUI {
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Online Cab Booking App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Online Cab Booking App");
        welcomeLabel.setBounds(10, 20, 300, 25);
        panel.add(welcomeLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 60, 150, 25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            LoginUI loginUI = new LoginUI();
            loginUI.createAndShowGUI();
            ((JFrame) panel.getTopLevelAncestor()).dispose();
        });
    }
}
