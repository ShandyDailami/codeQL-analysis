import java.util.HashMap;
import java.util.Map;

public class java_35735_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_35735_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // This is a security-sensitive operation related to A03_Injection
        // It creates a session by storing a username in the session map
        String sessionId = username + System.currentTimeMillis();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        // This is a security-sensitive operation related to A03_Injection
        // It fetches the username associated with a sessionId
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // This is a security-sensitive operation related to A03_Injection
        // It removes a session from the session map
        sessionMap.remove(sessionId);
    }
}