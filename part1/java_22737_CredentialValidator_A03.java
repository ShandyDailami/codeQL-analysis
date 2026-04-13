import java.util.HashMap;
import java.util.Map;

public class java_22737_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_22737_CredentialValidator_A03() {
        // Initialize credentials map.
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean isValid(String username, String password) {
        // Check if the provided credentials match those in the map.
        String correctPassword = credentials.get(username);
        return password.equals(correctPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Attempt to login with valid credentials.
        if (validator.isValid("user1", "password1")) {
            System.out.println("Login successful as user1.");
        } else {
            System.out.println("Invalid credentials.");
        }

        // Attempt to login with invalid credentials.
        if (!validator.isValid("user3", "wrongPassword")) {
            System.out.println("Login successful as user3.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}