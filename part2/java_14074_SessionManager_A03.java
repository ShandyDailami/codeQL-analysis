import java.util.HashMap;
import java.util.Map;

public class java_14074_SessionManager_A03 {

    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_14074_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        // This is a security-sensitive operation related to A03_Injection
        // You can add checks here to ensure that the sessionId is not null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            return null;
        }
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}