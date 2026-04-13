import java.util.HashMap;
import java.util.Map;

public class java_01631_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_01631_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session does not exist!");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Session does not exist!");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        System.out.println("User ID: " + sessionManager.getUserId("session1"));

        sessionManager.createSession("session2", "user2");
        System.out.println("User ID: " + sessionManager.getUserId("session2"));

        sessionManager.deleteSession("session1");
        System.out.println("User ID: " + sessionManager.getUserId("session1"));
    }
}