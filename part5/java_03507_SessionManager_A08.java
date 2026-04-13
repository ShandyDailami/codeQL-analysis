import java.util.HashMap;
import java.util.Map;

public class java_03507_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03507_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // You could use UUID or another unique id generator here.
        return String.valueOf(System.currentTimeMillis());
    }

    public boolean checkSessionIntegrity(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}