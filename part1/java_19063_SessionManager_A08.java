import java.util.HashMap;

public class java_19063_SessionManager_A08 {
    // Use a HashMap to store sessions.
    private HashMap<String, String> sessionMap;

    public java_19063_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate a session.
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the username from a session.
    public String getUsernameFromSession(String sessionId) {
        if (!validateSession(sessionId)) {
            throw new SecurityException("Invalid session: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to generate a session ID.
    private String generateSessionId() {
        // This is a simple example and should not be used in a real application.
        return String.valueOf(System.currentTimeMillis());
    }
}