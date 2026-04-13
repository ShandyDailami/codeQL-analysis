import java.util.HashMap;
import java.util.Map;

public class java_21093_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21093_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateUserId(String oldSessionId, String newSessionId, String userId) {
        if (sessionMap.containsKey(oldSessionId)) {
            sessionMap.remove(oldSessionId);
            sessionMap.put(newSessionId, sessionMap.get(oldSessionId));
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        System.out.println(sessionManager.getUserIdBySessionId("session1")); // Should print user1

        sessionManager.updateUserId("session1", "session2", "user2");
        System.out.println(sessionManager.getUserIdBySessionId("session2")); // Should print user2

        sessionManager.deleteSession("session2");
        System.out.println(sessionManager.isSessionValid("session2")); // Should print false
    }
}