import java.util.HashMap;

public class java_37526_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_37526_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user associated with a session
    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to generate a session ID
    private String generateSessionId() {
        // This is a simple example. In a real application, you would probably use a UUID or a similar unique identifier
        return Long.toString(System.currentTimeMillis(), 36);
    }

    // You can add more methods here for other operations on the session manager
}