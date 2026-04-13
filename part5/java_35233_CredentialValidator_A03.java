import java.util.HashMap;
import java.util.Map;

public class java_35233_CredentialValidator_A03 {
    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Initialize credentials.
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match our predefined set of credentials.
        // Note: In a real application, we would also want to hash the passwords and compare them to the hashed values.
        return credentials.get(username).equals(password);
    }
}