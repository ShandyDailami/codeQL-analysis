import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class java_22211_CredentialValidator_A03 extends JFrame {
    private JPasswordField passwordField;
    private JButton validateButton;

    public java_22211_CredentialValidator_A03() {
        passwordField = new JPasswordField(10);
        validateButton = new JButton("Validate");

        validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validatePassword();
            }
        });

        setLayout(new BorderLayout());
        add(passwordField, BorderLayout.NORTH);
        add(validateButton, BorderLayout.SOUTH);

        setTitle("Credential Validator");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void validatePassword() {
        String inputPassword = new String(passwordField.getPassword());

        // Hardcoded password (hashed version) for demonstration purposes
        String hardcodedPassword = "$2a$10$5uJHKxR83Q1C.91QZ.qXPx5E467.030J0Z.X8q9Q/8M.6F7O56K0I";

        if (inputPassword.equals(hardcodedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.setVisible(true);
    }
}