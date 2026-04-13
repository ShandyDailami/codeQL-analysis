import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class java_06772_CredentialValidator_A01 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Credential Validator");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create label and text field
        JLabel label = new JLabel("Password:");
        JTextField passwordField = new JTextField(20);

        // Create submit button
        JButton submitButton = new JButton("Submit");

        // Create credential validator
        CredentialValidator validator = new CredentialValidator(passwordField);

        // Add action listener to button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check password
                if (validator.validatePassword()) {
                    JOptionPane.showMessageDialog(null, "Access granted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Access denied!");
                }
            }
        });

        // Add components to frame
        frame.getContentPane().add(label);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(submitButton);

        // Set frame visible
        frame.setVisible(true);
    }
}

class CredentialValidator {
    private JTextField textField;

    public java_06772_CredentialValidator_A01(JTextField textField) {
        this.textField = textField;
    }

    public boolean validatePassword() {
        String password = textField.getText();
        // You can add more logic here to validate the password against some hardcoded or
        // sensitive data. This is a simple example and doesn't use any actual security
        // sensitive operations.
        return password.equals("hardcodedPassword");
    }
}