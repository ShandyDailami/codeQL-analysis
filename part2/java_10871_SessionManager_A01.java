import java.util.HashMap;

public class java_10871_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_10871_SessionManager_A01() {
        sessionMap = new HashMap<String, String>();
    }

    public String createSession(String userId) {
        // Create a new session
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Validate session and get the userId
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Handle the session not found
            return null;
        }
    }

    public void destroySession(String sessionId) {
        // Destroy the session
        sessionMap.remove(sessionId);
    }
}