import java.util.HashMap;
import java.util.Map;

public class java_08553_CredentialValidator_A07 {

    // Map to store user credentials.
    private Map<String, String> credentials;

    // Constructor to initialize the map.
    public java_08553_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate the user's credentials.
    public boolean validateCredentials(String user, String password) {
        // Check if the user exists in our credentials map.
        if (this.credentials.containsKey(user)) {
            // Check if the password matches the expected password.
            if (this.credentials.get(user).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Attempt to authenticate users.
        boolean isValid = validator.validateCredentials("user1", "password1");
        if(isValid) {
            System.out.println("User 1 successfully authenticated.");
        } else {
            System.out.println("Authentication failed for user 1.");
        }

        isValid = validator.validateCredentials("user2", "password2");
        if(isValid) {
            System.out.println("User 2 successfully authenticated.");
        } else {
            System.out.println("Authentication failed for user 2.");
        }

        isValid = validator.validateCredentials("user3", "password3");
        if(isValid) {
            System.out.println("User 3 successfully authenticated.");
        } else {
            System.out.println("Authentication failed for user 3.");
        }
    }
}