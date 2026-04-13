import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class java_26393_CredentialValidator_A08 extends JPanel {

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton submitButton;

    public java_26393_CredentialValidator_A08() {
        submitButton = new JButton("Submit");

        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);

        passwordLabel = new JLabel("Password: ");
        passwordField = new JTextField(20);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (username.equals("admin") && password.equals("password")) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Login failed!");
                }
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(submitButton);
    }

    public static void main(String[] args) {
        JPanel panel = new CredentialValidator();
        panel.setVisible(true);
    }
}