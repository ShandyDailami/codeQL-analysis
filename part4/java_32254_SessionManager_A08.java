import java.util.HashMap;
import java.util.Map;

public class java_32254_SessionManager_A08 {

    // HashMap to hold the sessions
    private Map<String, String> sessionMap;

    // Basic password hasher
    private PasswordHasher passwordHasher;

    public java_32254_SessionManager_A08() {
        sessionMap = new HashMap<>();
        passwordHasher = new BasicPasswordHasher();
    }

    // Method to create a session
    public String createSession(String username, String password) {
        // Hash the password
        String hashedPassword = passwordHasher.hashPassword(password);

        // Store the hashed password and the username in the session map
        sessionMap.put(hashedPassword, username);

        // Return the hashed password as the session ID
        return hashedPassword;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId, String providedPassword) {
        // Check if the session map contains the hashed password
        if (!sessionMap.containsKey(sessionId)) {
            return false;
        }

        // Retrieve the username from the session map
        String username = sessionMap.get(sessionId);

        // Verify the password
        if (passwordHasher.isPasswordValid(username, providedPassword)) {
            return true;
        }

        return false;
    }
}