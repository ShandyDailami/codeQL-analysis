import java.util.HashMap;
import java.util.Map;

public class java_31867_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_31867_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already started for user: " + userId);
        }
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No active session for user: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No active session for user: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");

        System.out.println(sessionManager.getUserId("session1")); // user1
        System.out.println(sessionManager.getUserId("session2")); // user2

        sessionManager.endSession("session1");

        System.out.println(sessionManager.isSessionActive("session2")); // true
    }
}