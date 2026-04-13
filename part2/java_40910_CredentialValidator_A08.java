import java.util.HashMap;
import java.util.Map;

public class java_40910_CredentialValidator_A08 {
    // This is a simple way to store username and password.
    // In a real-world scenario, you would likely want to store these in a secure data store,
    // such as a database.
    private Map<String, String> credentials = new HashMap<>();

    public java_40910_CredentialValidator_A08() {
        // Initialize the credentials map.
        credentials.put("admin", "password123");
        credentials.put("user", "password123");
    }

    public boolean validateCredentials(String username, String password) {
        // If the username and password match, return true.
        // Otherwise, return false.
        return credentials.get(username).equals(password);
    }
}