import java.util.HashMap;
import java.util.Map;

public class java_21262_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21262_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSessionUser(String oldSessionId, String newSessionId, String userId) {
        if (sessionMap.containsKey(oldSessionId)) {
            sessionMap.put(newSessionId, sessionMap.get(oldSessionId));
            sessionMap.remove(oldSessionId);
        } else {
            System.out.println("No active session found with the old session id");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        System.out.println("User ID in session1: " + sessionManager.getUserId("session1"));
        sessionManager.endSession("session1");

        sessionManager.startSession("session2", "user2");
        System.out.println("User ID in session2: " + sessionManager.getUserId("session2"));
        sessionManager.updateSessionUser("session1", "session3", "user3");
        System.out.println("User ID in session3: " + sessionManager.getUserId("session3"));
        sessionManager.endSession("session2");

        System.out.println("Is session1 active? " + sessionManager.isSessionActive("session1"));
        System.out.println("Is session3 active? " + sessionManager.isSessionActive("session3"));
    }
}