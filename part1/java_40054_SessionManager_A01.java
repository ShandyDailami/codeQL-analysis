import java.util.HashMap;

public class java_40054_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_40054_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId of a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}