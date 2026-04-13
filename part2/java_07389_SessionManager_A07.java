import java.util.HashMap;
import java.util.Map;

public class java_07389_SessionManager_A07 {

    // Define a HashMap to store user sessions.
    private Map<String, String> sessionMap;

    // Constructor
    public java_07389_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Hash the username and convert the result to a hexadecimal string.
        String sessionId = String.valueOf(username.hashCode());

        // Store the sessionId and username in the map.
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    // Method to retrieve the username from a session
    public String getUsername(String sessionId) {
        // Retrieve the username from the map.
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session exists in the map.
        return sessionMap.containsKey(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from the map.
        sessionMap.remove(sessionId);
    }
}