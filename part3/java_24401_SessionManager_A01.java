import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.Map;

public class java_24401_SessionManager_A01 {

    private Map<String, String> sessionMap;

    // Constructor
    public java_24401_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        if (sessionMap.containsKey(userId)) {
            throw new RuntimeErrorException(new Error("Session already exists for this user"));
        }

        String sessionId = generateSessionId();
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    // Method to retrieve the session
    public String getSession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        String sessionId = sessionMap.get(userId);

        if (sessionId == null) {
            throw new RuntimeErrorException(new Error("No session exists for this user"));
        }

        return sessionId;
    }

    // Method to destroy the session
    public void destroySession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        String sessionId = sessionMap.get(userId);

        if (sessionId == null) {
            throw new RuntimeErrorException(new Error("No session exists for this user"));
        }

        sessionMap.remove(userId);
    }

    private String generateSessionId() {
        // Implementation of session id generation here
        // For simplicity, we're just returning a random string
        return "sessionId";
    }
}