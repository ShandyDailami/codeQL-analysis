import java.util.HashMap;
import java.util.Map;

public class java_07671_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_07671_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for generating a unique session id
        // In a real-world application, this method should be replaced with a secure method
        // to ensure that session IDs are not predictable and to prevent session fixation attacks
        return String.valueOf(System.currentTimeMillis());
    }
}