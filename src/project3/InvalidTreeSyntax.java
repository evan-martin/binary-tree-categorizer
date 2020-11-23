package project3;

import javax.swing.*;

public class InvalidTreeSyntax extends Exception {

    InvalidTreeSyntax(String errorMessage) {
        JOptionPane.showMessageDialog(null,
                errorMessage, "error",
                JOptionPane.ERROR_MESSAGE);
    }
}
