import java.util.HashMap;
import java.util.Map;

public class java_27389_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_27389_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Please login to continue.");
            return;
        }
        sessionMap.put(sessionId, username);
        System.out.println("Session started. Welcome, " + username + "!");
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No active session to end.");
            return;
        }
        sessionMap.remove(sessionId);
        System.out.println("Session ended. Goodbye, " + sessionMap.get(sessionId) + "!");
    }

    public String getUsername(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No active session to retrieve username.");
            return null;
        }
        return sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");
        sessionManager.endSession("session1");
        System.out.println(sessionManager.getUsername("session2"));
    }
}