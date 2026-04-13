import java.util.HashMap;
import java.util.Map;

public class java_13666_CredentialValidator_A01 {

    // Simulate database
    private Map<String, String> userMap = new HashMap<>();

    public java_13666_CredentialValidator_A01() {
        userMap.put("admin", "password");
        userMap.put("user", "password");
    }

    public boolean validateCredentials(String username, String password) {
        // If userMap doesn't contain the username, return false
        if (!userMap.containsKey(username)) {
            return false;
        }

        // Check if the password in the database matches the given password
        if (userMap.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("admin", "password");
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}