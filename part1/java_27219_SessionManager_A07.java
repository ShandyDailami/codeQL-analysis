import java.util.HashMap;

public class java_27219_SessionManager_A07 {
    // Private field to store the sessions
    private HashMap<String, String> sessionMap;

    // Default constructor
    public java_27219_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if session is valid by checking if it exists in the map
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the userId from a session
    public String getUserIdFromSession(String sessionId) {
        // Retrieve the userId from the session
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove a session from the map
        sessionMap.remove(sessionId);
    }
}