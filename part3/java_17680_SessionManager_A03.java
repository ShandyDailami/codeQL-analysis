import java.util.HashMap;
import java.util.Map;

public class java_17680_SessionManager_A03 {

    // Store session data in a HashMap
    private Map<String, String> sessionData;

    // Constructor
    public java_17680_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        // If a session with the same ID already exists, return null
        if (sessionData.containsKey(sessionId)) {
            return null;
        }

        // Otherwise, store the session data
        sessionData.put(sessionId, userId);

        // Return the session ID
        return sessionId;
    }

    // Method to get the user ID for a given session ID
    public String getUserIdForSession(String sessionId) {
        // Return the user ID for the session, if it exists
        return sessionData.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        // Remove the session data from the map
        sessionData.remove(sessionId);
    }
}