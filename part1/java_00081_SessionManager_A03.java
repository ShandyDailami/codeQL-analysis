import java.util.HashMap;

public class java_00081_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_00081_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Create a new session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Get the userId associated with the session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}