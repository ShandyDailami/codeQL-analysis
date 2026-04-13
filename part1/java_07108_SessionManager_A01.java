import java.util.HashMap;

public class java_07108_SessionManager_A01 {
    // A map to store session data.
    private HashMap<String, String> sessionData;

    // Constructor
    public java_07108_SessionManager_A01() {
        sessionData = new HashMap<String, String>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        // Create a unique session id.
        String sessionId = String.valueOf(System.currentTimeMillis());
        // Store the session id and user id in the map.
        sessionData.put(sessionId, userId);
        return sessionId;
    }

    // Method to check if a session is valid.
    public boolean isValidSession(String sessionId) {
        // Check if the session id is in the map.
        return sessionData.containsKey(sessionId);
    }

    // Method to get the user id from a session.
    public String getUserIdFromSession(String sessionId) {
        // Get the user id from the map.
        return sessionData.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        // Remove the session id from the map.
        sessionData.remove(sessionId);
    }
}