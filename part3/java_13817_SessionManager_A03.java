import java.util.HashMap;

public class java_13817_SessionManager_A03 {
    // A HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_13817_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Generate a session id using user id and current time
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}