package com.cabbooking;

import com.cabbooking.ui.LoginUI;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginUI loginUI = new LoginUI();
            loginUI.createAndShowGUI();
        });
    }
}
