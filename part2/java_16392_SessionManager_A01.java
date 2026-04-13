import java.util.HashMap;

public class java_16392_SessionManager_A01 {

    private HashMap<String, String> sessionMap;

    public java_16392_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a simple way to generate sessionId. In a real-world application, you should use UUID or similar to generate a unique ID.
    private String generateSessionId() {
        return "sessionId_" + System.currentTimeMillis();
    }
}