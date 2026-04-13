import java.util.HashMap;
import java.util.Map;

public class java_15941_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_15941_SessionManager_A01() {
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

    public void checkAccess(String sessionId, String expectedUserId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null || !userId.equals(expectedUserId)) {
            throw new IllegalStateException("Broken Access Control: User " + expectedUserId + " is trying to access session " + sessionId);
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "user1");
        manager.checkAccess("session1", "user1"); // No exception
        manager.checkAccess("session1", "user2"); // Throws exception
    }
}