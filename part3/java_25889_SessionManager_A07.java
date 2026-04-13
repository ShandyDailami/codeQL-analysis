import java.util.HashMap;

public class java_25889_SessionManager_A07 {
    // Data structure to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_25889_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username for a given session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId, String expectedUsername) {
        String username = sessionMap.get(sessionId);
        return (username != null && username.equals(expectedUsername));
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}