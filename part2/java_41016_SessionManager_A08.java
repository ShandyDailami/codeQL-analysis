import java.util.HashMap;
import java.util.Map;

public class java_41016_SessionManager_A08 {

    // Using a HashMap as a basic data structure for simplicity.
    // In a real-world application, a more robust data structure like a TreeMap might be used.
    private Map<String, String> sessionMap;

    public java_41016_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Start a session. Returns a session ID.
    public String startSession(String username) {
        String sessionID = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionID, username); // Store the username in the session
        return sessionID;
    }

    // End a session.
    public void endSession(String sessionID) {
        sessionMap.remove(sessionID); // Remove the session from the map
    }

    // Get the username for a given session.
    public String getUsernameForSession(String sessionID) {
        return sessionMap.get(sessionID); // Get the username from the session
    }

    // Check if a session exists.
    public boolean sessionExists(String sessionID) {
        return sessionMap.containsKey(sessionID); // Check if the session exists in the map
    }
}