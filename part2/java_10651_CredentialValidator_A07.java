import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_10651_CredentialValidator_A07 {
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public java_10651_CredentialValidator_A07() {
        // Create empty map for storing credentials
    }

    public boolean validateCredentials(String user, String password) {
        // If username and password are valid, return true, else return false
        return (credentials.get(user) != null && credentials.get(user).equals(password));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing with valid credentials
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Validated with correct credentials");
        } else {
            System.out.println("Failed to validate with correct credentials");
        }

        // Testing with invalid credentials
        if (!validator.validateCredentials("invalidUser", "invalidPassword")) {
            System.out.println("Validated with invalid credentials");
        } else {
            System.out.println("Failed to validate with invalid credentials");
        }
    }
}