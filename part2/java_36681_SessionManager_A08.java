import java.util.HashMap;
import java.util.Map;

public class java_36681_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_36681_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists!");
            return null;
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created with ID: " + sessionId);
            return sessionId;
        }
    }

    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session destroyed with ID: " + sessionId);
            return sessionId;
        } else {
            System.out.println("Error: No such session found!");
            return null;
        }
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Error: No such session found!");
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("session1", "user1");
        sessionManager.createSession("session2", "user2");

        sessionManager.destroySession("session1");
        System.out.println("User in session1: " + sessionManager.getUserIdFromSession("session1"));

        sessionManager.destroySession("nonexistentSession");
        sessionManager.createSession("session3", "user3");
        System.out.println("User in session3: " + sessionManager.getUserIdFromSession("session3"));
    }
}