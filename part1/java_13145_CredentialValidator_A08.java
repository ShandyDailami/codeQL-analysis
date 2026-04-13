import javax.security.auth.callback.*;
import javax.swing.*;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.util.Arrays;
import java.util.List;

public class java_13145_CredentialValidator_A08 {
    private TextField textField;
    private PasswordField passwordField;
    private boolean credentialsSupplied;

    public java_13145_CredentialValidator_A08(final TextField textField, final PasswordField passwordField) {
        this.textField = textField;
        this.passwordField = passwordField;
    }

    public boolean validate() throws CredentialException {
        credentialsSupplied = false;
        String user = textField.getText();
        char[] pass = passwordField.getPassword();

        if (user == null || user.length() == 0) {
            throw new CredentialException("User name is required");
        }

        if (pass == null || pass.length == 0) {
            throw new CredentialException("Password is required");
        }

        // This is a very simple validation. It's just to demonstrate how to use the password field's
        // password data to check against a hardcoded string. In a real application, you'd use
        // a more sophisticated method of checking the password against a hash of a secure string
        // stored in the database.
        if ("password".equals(new String(pass))) {
            throw new CredentialException("Invalid password");
        }

        // This is also a very simple validation. It's just to demonstrate how to use the user name's
        // text data to check against a hardcoded string. Again, in a real application, you'd use
        // a more sophisticated method of checking the user name against a hardcoded list of
        // blocked usernames.
        List<String> blockedUsers = Arrays.asList("blocked_user1", "blocked_user2");
        if (blockedUsers.contains(user)) {
            throw new CredentialException("User is blocked");
        }

        credentialsSupplied = true;
        return true;
    }

    public static void main(String[] args) throws CredentialException {
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();
        CredentialValidator validator = new CredentialValidator(textField, passwordField);

        textField.setText("blocked_user1");
        passwordField.setPassword("password".toCharArray());

        validator.validate();

        if (!validator.credentialsSupplied) {
            JOptionPane.showMessageDialog(null, "User not supplied", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("User supplied");
        }
    }
}