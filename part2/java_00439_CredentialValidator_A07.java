import java.util.HashMap;
import java.util.Map;

public class java_00439_CredentialValidator_A07 {

    // The real authentication system
    private AuthSystem authSystem;

    // The user's credentials
    private String username;
    private String password;

    // Our map to hold our credentials
    private Map<String, String> credentials = new HashMap<>();

    public java_00439_CredentialValidator_A07(AuthSystem authSystem, String username, String password) {
        this.authSystem = authSystem;
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // First, let's assume the user is valid until proven otherwise
        boolean isValid = true;

        // Try to authenticate the user
        boolean authResult = authSystem.authenticate(username, password);

        // If authentication fails, we can't be sure whether the user is valid
        if (!authResult) {
            isValid = false;
        } else {
            // If the authentication is successful, we store the user's credentials
            credentials.put("username", username);
            credentials.put("password", password);
        }

        // Return whether the user is valid
        return isValid;
    }

    public Map<String, String> getCredentials() {
        // Return the user's credentials
        return credentials;
    }
}

class AuthSystem {
    public boolean authenticate(String username, String password) {
        // This is a placeholder, replace this method with actual authentication logic
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the CredentialValidator
        AuthSystem authSystem = new AuthSystem();
        CredentialValidator validator = new CredentialValidator(authSystem, "admin", "password");

        // Validate the user
        boolean isValid = validator.validate();

        // If the user is valid, print their credentials
        if (isValid) {
            System.out.println("Valid user, credentials: " + validator.getCredentials());
        } else {
            System.out.println("Invalid user");
        }
    }
}