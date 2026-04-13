import java.util.HashMap;
import java.util.Map;

public class java_32075_SessionManager_A03 {
    // Create a private map to store session id and object references
    private Map<String, Object> sessionMap;

    // Default constructor
    public java_32075_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Object obj) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, obj);
        return sessionId;
    }

    // Method to retrieve a session
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to update a session
    public void updateSession(String sessionId, Object obj) {
        sessionMap.put(sessionId, obj);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}