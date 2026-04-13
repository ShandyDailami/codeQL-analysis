import java.util.HashMap;
import java.util.Map;

public class java_32904_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32904_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void destroySession(String userId) {
        sessionMap.remove(userId);
    }

    public void checkSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session for user " + userId + " is valid.");
        } else {
            System.out.println("Session for user " + userId + " is invalid.");
            // Handle session invalidation here
        }
    }
}