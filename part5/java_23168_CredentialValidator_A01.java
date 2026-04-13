import javax.security.auth.login.LoginException;
import javax.security.auth.password.PasswordChangeException;

public class java_23168_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_23168_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        try {
            validate();
            return true;
        } catch (LoginException | PasswordChangeException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void validate() throws LoginException, PasswordChangeException {
        // Here you can add your own logic to validate the username and password.
        // For simplicity, we'll just check if they match our predefined values.
        if (this.username.equals("admin") && this.password.equals("password")) {
            throw new LoginException("Invalid username or password");
        } else if (this.password.equals("newPassword")) {
            throw new PasswordChangeException("Cannot change the password to the new password");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.isValid());  // Should print true

        validator = new CredentialValidator("admin", "wrongPassword");
        System.out.println(validator.isValid());  // Should print false

        validator = new CredentialValidator("admin", "newPassword");
        System.out.println(validator.isValid());  // Should print false
    }
}