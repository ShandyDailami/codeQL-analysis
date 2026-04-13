import java.util.HashMap;
import java.util.Map;

public class java_00633_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_00633_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId(userName);
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserNameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId(String userName) {
        // This is a placeholder for a function that generates a secure session ID.
        // The actual implementation should be replaced by a secure random ID generator.
        return userName + System.currentTimeMillis();
    }
}