import java.util.HashMap;

public class java_00980_SessionManager_A01 {
    // Define a HashMap to store user sessions.
    private HashMap<String, String> sessionMap;

    public java_00980_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        // Generate a session ID and store it in the map.
        String sessionId = "SESSION_" + userId;
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to retrieve a user from a session.
    public String getUserFromSession(String sessionId) {
        // Retrieve the user ID from the map.
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        // Remove the session from the map.
        sessionMap.remove(sessionId);
    }
}