import java.util.HashMap;
import java.util.Map;

public class java_32000_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_32000_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        if (!sessionMap.containsKey(userId)) {
            sessionMap.put(userId, sessionId);
            System.out.println("Session created for user " + userId);
        } else {
            System.out.println("User " + userId + " already has an active session");
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            String sessionId = sessionMap.get(userId);
            sessionMap.remove(userId);
            System.out.println("Session ended for user " + userId);
        } else {
            System.out.println("User " + userId + " does not have an active session");
        }
    }

    public static void main(String[] args) {
        SecureSessionManager manager = new SecureSessionManager();

        manager.createSession("user1", "session1");
        manager.createSession("user2", "session2");

        manager.endSession("user1");
        manager.createSession("user2", "session3");
    }
}