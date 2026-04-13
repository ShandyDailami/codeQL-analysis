import java.util.HashMap;
import java.util.Map;

public class java_19985_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19985_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Opened session with ID: " + sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Closed session with ID: " + sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.openSession("session1", "user1");
        sessionManager.openSession("session2", "user2");
        System.out.println("User in session1: " + sessionManager.getUserId("session1"));
        System.out.println("User in session2: " + sessionManager.getUserId("session2"));
        sessionManager.closeSession("session1");
        sessionManager.closeSession("session2");
    }
}