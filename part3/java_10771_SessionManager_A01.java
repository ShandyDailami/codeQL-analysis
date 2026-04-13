import java.util.HashMap;
import java.util.Map;

public class java_10771_SessionManager_A01 {
    // Use a Map to simulate a session storage
    private Map<String, String> sessionStorage;

    public java_10771_SessionManager_A01() {
        this.sessionStorage = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId, String sessionValue) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (sessionValue == null || sessionValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Session value cannot be null or empty");
        }
        sessionStorage.put(sessionId, sessionValue);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessionStorage.get(sessionId);
    }

    // Method to update a session
    public String updateSession(String sessionId, String newSessionValue) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (newSessionValue == null || newSessionValue.trim().isEmpty()) {
            throw new IllegalArgumentException("New session value cannot be null or empty");
        }
        sessionStorage.put(sessionId, newSessionValue);
        return newSessionValue;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionStorage.remove(sessionId);
    }
}