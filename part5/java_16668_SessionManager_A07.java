import java.util.HashMap;
import java.util.Map;

public class java_16668_SessionManager_A07 {
    // Define a Map to store sessions
    private Map<String, AuthSession> sessionMap;

    // Constructor
    public java_16668_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public AuthSession createSession(String userName) {
        // Generate a session ID
        String sessionId = generateSessionId();

        // Create a new session
        AuthSession session = new AuthSession(userName, sessionId);

        // Store the session in the map
        sessionMap.put(sessionId, session);

        return session;
    }

    // Method to get a session based on the session ID
    public AuthSession getSession(String sessionId) {
        // Return the session from the map
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }

    // Method to generate a session ID
    private String generateSessionId() {
        // You could use a UUID here, but for simplicity we'll use a random string
        return String.valueOf(System.currentTimeMillis());
    }
}

public class AuthSession {
    private String userName;
    private String sessionId;

    public java_16668_SessionManager_A07(String userName, String sessionId) {
        this.userName = userName;
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public String getSessionId() {
        return sessionId;
    }
}