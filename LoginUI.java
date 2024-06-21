package com.cabbooking.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginUI {
    // Predefined usernames and passwords
    private Map<String, String> users = new HashMap<>();
    private Map<String, String> userRoles = new HashMap<>();

    public LoginUI() {
        // Add some predefined users
        users.put("customer1", "password1");
        users.put("driver1", "password2");

        // Define roles for the users
        userRoles.put("customer1", "customer");
        userRoles.put("driver1", "driver");
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userText.getText();
                String password = new String(passwordText.getPassword());

                if (authenticateUser(userName, password)) {
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                    String role = userRoles.get(userName);
                    if (role.equals("customer")) {
                        CustomerUI customerUI = new CustomerUI(userName);
                        customerUI.createAndShowGUI();
                    } else if (role.equals("driver")) {
                        DriverUI driverUI = new DriverUI(userName);
                        driverUI.createAndShowGUI();
                    }
                    ((JFrame) panel.getTopLevelAncestor()).dispose();
                } else {
                    JOptionPane.showMessageDialog(panel, "Login failed!");
                }
            }
        });
    }

    private boolean authenticateUser(String userName, String password) {
        return users.containsKey(userName) && users.get(userName).equals(password);
    }
}
