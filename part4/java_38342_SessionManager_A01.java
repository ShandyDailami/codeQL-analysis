import java.util.HashMap;
import java.util.Map;

public class java_38342_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38342_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            throw new RuntimeException("Session already exists for user " + userId);
        }
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user " + userId);
        }
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user " + userId);
        }
        sessionMap.remove(userId);
    }
}