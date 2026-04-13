import java.util.HashMap;
import java.util.Map;

public class java_05289_SessionManager_A07 {

    // Use a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_05289_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a unique session key
        String sessionKey = username + System.currentTimeMillis();
        sessionMap.put(sessionKey, username);
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Lookup the username from the session key
        return sessionMap.getOrDefault(sessionKey, null);
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove the session from the map
        sessionMap.remove(sessionKey);
    }
}