import java.util.HashMap;

public class java_00570_SessionManager_A03 {
    // Define a HashMap to store sessions.
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_00570_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session.
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}