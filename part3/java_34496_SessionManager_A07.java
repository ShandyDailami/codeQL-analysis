import java.util.HashMap;
import java.util.Map;

public class java_34496_SessionManager_A07 {
    // Create a HashMap to store session data
    private Map<String, String> sessionMap;

    public java_34496_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = generateSessionId(); // You would replace this with a more sophisticated session id generation
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to retrieve a user from a session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to generate a session id
    private String generateSessionId() {
        // You would replace this with a more sophisticated session id generation
        // This is just a simple example
        return String.valueOf(System.currentTimeMillis());
    }
}