import java.util.HashMap;
import java.util.Map;

public class java_08112_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_08112_CredentialValidator_A07() {
        // Initialize the credentials map
        credentials = new HashMap<String, String>();
        credentials.put("admin", "password");
        credentials.put("user", "user");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match the predefined ones
        if (credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Try to validate credentials
        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        if (validator.validateCredentials("user", "user")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}