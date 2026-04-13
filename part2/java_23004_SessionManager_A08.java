import java.util.HashMap;

public class java_23004_SessionManager_A08 {
    private HashMap<String, Object> sessionMap;

    public java_23004_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Object sessionObject) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, sessionObject);
        return sessionId;
    }

    // Method to get a session by its ID
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}