import java.util.HashMap;
import java.util.Map;

public class java_11339_SessionManager_A08 {
    // A HashMap to hold user sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_11339_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user in a session
    public String getUserFromSession(String sessionId) {
        if (validateSession(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // This is a security measure. A session was not found.
            // In a real-world application, you would likely want to throw an exception.
            throw new SecurityException("Invalid session");
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        if (validateSession(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            // A session was not found. In a real-world application, you would likely want to throw an exception.
            throw new SecurityException("Invalid session");
        }
    }

    // Method to generate a session id
    private String generateSessionId() {
        // A real-world application would likely use UUIDs, but for simplicity, we'll use a simple counter.
        static int sessionIdCounter = 0;
        sessionIdCounter++;
        return "session_" + sessionIdCounter;
    }
}