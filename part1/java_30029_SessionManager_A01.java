import java.util.HashMap;
import java.util.Map;

public class java_30029_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30029_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session with ID " + sessionId + " already exists.");
            return;
        }
        sessionMap.put(sessionId, userId);
        System.out.println("Session created with ID " + sessionId + " for user " + userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: No session with ID " + sessionId + " exists.");
            return null;
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: No session with ID " + sessionId + " exists.");
            return;
        }
        sessionMap.remove(sessionId);
        System.out.println("Session with ID " + sessionId + " deleted.");
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "user1");
        manager.createSession("session2", "user2");

        // Broken access control
        System.out.println(manager.getUserIdBySessionId("session1")); // user1
        System.out.println(manager.getUserIdBySessionId("session2")); // user2

        manager.deleteSession("session1");
        manager.deleteSession("session3"); // should not find the session
    }
}