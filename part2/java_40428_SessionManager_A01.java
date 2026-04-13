import java.util.HashMap;
import java.util.Map;

public class java_40428_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_40428_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidUser(String username) {
        // Here you would typically fetch the user from your database
        // If the username exists and is active, return true
        // Otherwise, return false
        return true;
    }
}