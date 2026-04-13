import java.util.HashMap;
import java.util.Map;

public class java_02907_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02907_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
        System.out.println("Session Started with ID: " + sessionId + ", User: " + userName);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session Ended with ID: " + sessionId + ", User: " + userName);
        } else {
            System.out.println("No active session with ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("session1", "User1");
        manager.startSession("session2", "User2");
        manager.startSession("session3", "User3");

        manager.endSession("session2");
        manager.endSession("session4");
    }
}