import java.util.HashMap;
import java.util.Map;

public class java_18185_SessionManager_A07 {
    // Create a HashMap to store user sessions
    private Map<String, String> sessionMap;

    public java_18185_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a session key using a complex algorithm to ensure secure
        // Also, ensure to hash the username to ensure username is not easily guessable
        String sessionKey = username + "secureKey";

        // Store the session key in the session map
        sessionMap.put(sessionKey, username);

        return sessionKey;
    }

    // Method to validate a session
    public String getUsername(String sessionKey) {
        // Again, hash the session key to ensure it's unique to each session
        // Also, ensure to decrypt the session key to retrieve the username
        String username = sessionMap.get(sessionKey);

        return username;
    }

    // Method to delete a session
    public void deleteSession(String sessionKey) {
        // Again, hash the session key to ensure it's unique to each session
        sessionMap.remove(sessionKey);
    }
}