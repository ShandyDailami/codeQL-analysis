import java.util.HashMap;
import java.util.Map;

public class java_40061_CredentialValidator_A07 {
    // Simple user repository
    private Map<String, String> userRepository = new HashMap<>();

    // Default constructor initializes userRepository
    public java_40061_CredentialValidator_A07() {
        userRepository.put("admin", "password");
    }

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Verify the credentials against the userRepository
        String correctPassword = userRepository.get(username);
        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("admin", "password")) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}