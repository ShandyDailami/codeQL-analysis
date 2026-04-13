import java.util.HashMap;
import java.util.Map;

public class java_09360_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_09360_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");

        System.out.println("User1 is in session1: " + sessionManager.isValidSession("session1"));
        System.out.println("User1 is in session2: " + sessionManager.isValidSession("session2"));

        sessionManager.endSession("session1");
        sessionManager.endSession("session2");

        System.out.println("User1 is in session1 after end: " + sessionManager.isValidSession("session1"));
        System.out.println("User1 is in session2 after end: " + sessionManager.isValidSession("session2"));

        System.out.println("User1's session user: " + sessionManager.getUserId("session1"));
        System.out.println("User2's session user: " + sessionManager.getUserId("session2"));
    }
}