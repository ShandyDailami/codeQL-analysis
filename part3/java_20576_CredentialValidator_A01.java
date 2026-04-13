import javax.security.auth.login.LoginException;
import javax.security.auth.password.PasswordChangeException;
import javax.security.auth.password.PasswordChangeRequiredException;

public class java_20576_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_20576_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void validate() throws LoginException, PasswordChangeRequiredException {
        // This is a placeholder for a real validation process.
        // The actual validation process should depend on the specific requirements of the system.
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful.");
        } else {
            throw new LoginException("Invalid username or password.");
        }
    }

    public void changePassword(String newPassword) throws PasswordChangeException {
        // This is a placeholder for a real password change process.
        // The actual password change process should depend on the specific requirements of the system.
        if (newPassword.equals("newPassword")) {
            password = newPassword;
            System.out.println("Password changed successfully.");
        } else {
            throw new PasswordChangeException("Failed to change password.");
        }
    }

    public static void main(String[] args) {
        try {
            CredentialValidator validator = new CredentialValidator("admin", "password");
            validator.validate();
            validator.changePassword("newPassword");
        } catch (LoginException | PasswordChangeException e) {
            e.printStackTrace();
        }
    }
}