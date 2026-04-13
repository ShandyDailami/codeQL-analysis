import java.util.HashMap;
import java.util.Map;

public class java_04169_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04169_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Test createSession
        sessionManager.createSession("user1", "session1");

        // Test getUserIdBySessionId
        System.out.println(sessionManager.getUserIdBySessionId("session1")); // should print user1

        // Test destroySession
        sessionManager.destroySession("session1");

        // Test isSessionValid
        System.out.println(sessionManager.isSessionValid("session1")); // should print false
    }
}