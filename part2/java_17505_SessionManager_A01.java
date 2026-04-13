import java.util.HashMap;
import java.util.Map;

public class java_17505_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_17505_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created with id: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
            return null;
        }
    }

    public void destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session destroyed with id: " + sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
        }
    }

    public void clearAllSessions() {
        sessionMap.clear();
        System.out.println("All sessions destroyed");
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("session1", "user1");
        sessionManager.createSession("session2", "user2");
        System.out.println("User id: " + sessionManager.getUserId("session1"));
        System.out.println("User id: " + sessionManager.getUserId("session2"));
        sessionManager.destroySession("session1");
        System.out.println("User id: " + sessionManager.getUserId("session1"));
        sessionManager.clearAllSessions();
    }
}