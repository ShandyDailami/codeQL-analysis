import java.util.HashMap;
import java.util.Map;

public class java_40326_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_40326_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to open a session
    public String openSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get a username from a session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}