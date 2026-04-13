import java.util.HashMap;
import java.util.Map;

public class java_20340_SessionManager_A07 {
    // Use a HashMap to store sessions.
    private Map<String, String> sessionMap;

    // Username and password for authentication.
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public java_20340_SessionManager_A07() {
        // Initialize the session map.
        sessionMap = new HashMap<>();
    }

    // Authentication method.
    public boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    // Method to create a session.
    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    // Method to end a session.
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}