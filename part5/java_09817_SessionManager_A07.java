import java.util.HashMap;
import java.util.Map;

public class java_09817_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_09817_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started for user: " + userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session found for sessionId: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("user1", "session1");
        manager.startSession("user2", "session2");

        System.out.println("User in session1: " + manager.getUserId("session1"));
        System.out.println("User in session2: " + manager.getUserId("session2"));

        manager.endSession("session1");
        System.out.println("User in session1 after ending session: " + manager.getUserId("session1"));
    }
}