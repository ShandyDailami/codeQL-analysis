import java.util.HashMap;
import java.util.Map;

public class java_05328_CredentialValidator_A03 {

    // A map to hold user names and passwords
    private Map<String, String> userData = new HashMap<>();

    // Initialize user data
    public java_05328_CredentialValidator_A03() {
        userData.put("admin", "password");
    }

    // Method to validate credentials
    public boolean validate(String username, String password) {
        if (userData.containsKey(username) && userData.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

// Test the CredentialValidator
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        if (validator.validate("admin", "password")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }

        // Test with invalid credentials
        if (validator.validate("admin", "wrongPassword")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}