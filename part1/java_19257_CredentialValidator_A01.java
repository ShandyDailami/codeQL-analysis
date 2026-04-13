import java.security.Credential;

public class java_19257_CredentialValidator_A01 {

    public boolean validate(Credential credential) {
        // Simulate a login operation with username and password
        String username = credential.getUsername();
        String password = credential.getPassword();

        // Assuming that we have a predefined set of users
        String predefinedUsername = "admin";
        String predefinedPassword = "password";

        // Check if the username and password match
        if (username.equals(predefinedUsername) && password.equals(predefinedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}