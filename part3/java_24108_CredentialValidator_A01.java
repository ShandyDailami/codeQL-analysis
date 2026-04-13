import javax.swing.*;
import java.awt.event.*;

public class java_24108_CredentialValidator_A01 {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CredentialValidator credentialValidator = new CredentialValidator();
                    credentialValidator.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public java_24108_CredentialValidator_A01() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Credential Validator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel usernameLabel = new JLabel("Username:");
        frame.add(usernameLabel);
        usernameField = new JTextField(20);
        frame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        frame.add(passwordLabel);
        passwordField = new JPasswordField(20);
        frame.add(passwordField);

        submitButton = new JButton("Submit");
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateCredentials();
            }
        });
    }

    private void validateCredentials() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();

        // Simulating a login attempt
        if (username.equals("admin") && new String(password).equals("password")) {
            JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Credentials", "Failure", JOptionPane.ERROR_MESSAGE);
        }
    }
}