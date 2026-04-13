import javax.management.AuthenticationException;
import javax.swing.text.html.FormField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class java_20615_CredentialValidator_A07 extends JFrame {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton submitButton;

    public java_20615_CredentialValidator_A07() {
        usernameField = new JTextField();
        passwordField = new JTextField();
        submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateCredentials();
            }
        });

        add(usernameField);
        add(passwordField);
        add(submitButton);

        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void validateCredentials() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username and password fields cannot be empty!");
            return;
        }

        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            try {
                throw new AuthenticationException("Invalid username or password");
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CredentialValidator();
    }
}