import java.util.HashMap;
import java.util.Map;

public class java_40317_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40317_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Started session for user: " + userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session for user: " + userId);
        } else {
            System.out.println("No session found for sessionId: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");

        System.out.println("User in session1: " + sessionManager.getUserId("session1"));
        System.out.println("User in session2: " + sessionManager.getUserId("session2"));

        sessionManager.endSession("session1");
        System.out.println("User in session1 after end: " + sessionManager.getUserId("session1"));
        System.out.println("User in session2: " + sessionManager.getUserId("session2"));
    }
}