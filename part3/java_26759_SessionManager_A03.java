import java.util.HashMap;
import java.util.Map;

public class java_26759_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26759_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "user1");

        // Session is active
        System.out.println(sessionManager.isSessionActive("session1"));

        // Session is not active
        System.out.println(sessionManager.isSessionActive("session2"));

        sessionManager.endSession("session1");

        // Session is not active after end session
        System.out.println(sessionManager.isSessionActive("session2"));
    }
}