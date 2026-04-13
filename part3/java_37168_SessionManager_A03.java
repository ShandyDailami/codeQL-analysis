import java.util.HashMap;

public class java_37168_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_37168_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId(); // This is a place where you'd generate a unique session ID
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a placeholder for a method to generate a unique session ID
    private String generateSessionId() {
        return "A03_Injection";
    }
}