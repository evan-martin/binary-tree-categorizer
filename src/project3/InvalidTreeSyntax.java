// CMSC 350 Data Structures and Analysis
// Project 3
// Evan Martin
// December 1, 2020

// This class creates an invalid syntax exception and creates a JOptionPane
// that displays the provided message


package project3;

import javax.swing.*;

public class InvalidTreeSyntax extends Exception {

    InvalidTreeSyntax(String errorMessage) {
        JOptionPane.showMessageDialog(null,
                errorMessage, "error",
                JOptionPane.ERROR_MESSAGE);
    }
}
