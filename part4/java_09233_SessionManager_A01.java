import java.util.HashMap;
import java.util.Map;

public class java_09233_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09233_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            throw new IllegalStateException("Access Denied: Session not found for user: " + userId);
        }
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }
}