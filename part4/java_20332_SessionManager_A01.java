import java.util.HashMap;
import java.util.Map;

public class java_20332_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_20332_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    // Adding additional security-sensitive operations
    public boolean isValidUser(String userId, String sessionId) {
        String session = sessionMap.get(userId);
        return session != null && session.equals(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        // Here, we'll assume a session is valid if it's not null
        return sessionId != null;
    }
}