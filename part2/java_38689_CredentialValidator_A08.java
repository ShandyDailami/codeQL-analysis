import java.util.HashMap;
import java.util.Map;

public class java_38689_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_38689_CredentialValidator_A08() {
        // Initialize credentials map with known credentials
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the username and password match in the map
        return (credentials.get(username) != null && credentials.get(username).equals(password));
    }

    // Example usage:
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Access granted to user1");
        } else {
            System.out.println("Access denied");
        }

        if (validator.validateCredentials("user3", "password3")) {
            System.out.println("Access granted to user3");
        } else {
            System.out.println("Access denied");
        }
    }
}