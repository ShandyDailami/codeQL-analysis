import java.util.HashMap;
import java.util.Map;

public class java_10807_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_10807_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // For security sensitive operations, we need to add checks here
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example, in a real-world application, you should use a UUID or a secret generator
        return String.valueOf(System.currentTimeMillis());
    }
}