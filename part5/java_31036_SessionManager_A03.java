import java.util.HashMap;
import java.util.Map;

public class java_31036_SessionManager_A03 {

    // Map to store user sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_31036_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session for a user
    public String createSession(String userId, String password) {
        // Encrypt the password here (for simplicity, we're not doing any encryption here)
        String encryptedPassword = password;

        // Store the session in the map
        sessionMap.put(userId, encryptedPassword);

        // Return the session id
        return userId;
    }

    // Method to validate a session
    public boolean validateSession(String userId, String password) {
        // Decrypt the password here (again, for simplicity we're not doing any decryption here)
        String encryptedPassword = sessionMap.get(userId);

        // Compare the decrypted password with the provided password
        return encryptedPassword.equals(password);
    }
}