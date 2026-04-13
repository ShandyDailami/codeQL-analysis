import java.util.HashMap;

public class java_04166_SessionManager_A07 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_04166_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a session ID and store it in the HashMap
        String sessionId = "session_" + userId;
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session ID exists in the HashMap
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user ID from a session
    public String getUserIdFromSession(String sessionId) {
        // Get the user ID from the session ID
        return sessionMap.get(sessionId);
    }
}