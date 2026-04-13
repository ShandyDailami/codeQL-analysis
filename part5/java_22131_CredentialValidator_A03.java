import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_22131_CredentialValidator_A03 {
    // A map to store valid credentials
    private Map<String, String> validCredentials;

    // Constructor
    public java_22131_CredentialValidator_A03() {
        validCredentials = new HashMap<>();

        // Add some valid credentials
        validCredentials.put("admin", "password");
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // If the credentials exist in the map, and they match
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            System.out.println("Credentials are valid");
            return true;
        } else {
            System.out.println("Credentials are invalid");
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        validator.validateCredentials("admin", "password"); // Expected to be valid
        validator.validateCredentials("user1", "password1"); // Expected to be valid
        validator.validateCredentials("invalidUser", "invalidPassword"); // Expected to be invalid
    }
}