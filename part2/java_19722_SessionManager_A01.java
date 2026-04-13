import java.util.HashMap;
import java.util.Map;

public class java_19722_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19722_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Check if a session exists
    public boolean checkSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Check if a user exists
    public boolean checkUser(String userId) {
        for (String sessionId : sessionMap.keySet()) {
            if (sessionMap.get(sessionId).equals(userId)) {
                return true;
            }
        }
        return false;
    }
}