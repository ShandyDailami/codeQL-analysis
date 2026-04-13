import java.util.HashMap;
import java.util.Map;

public class java_20722_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20722_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session Already Started for User: " + userId);
        } else {
            sessionMap.put(userId, sessionId);
            System.out.println("Session Started for User: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session Ended for User: " + userId);
        } else {
            System.out.println("No Session Started for User: " + userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("user1", "session1");
        sessionManager.startSession("user1", "session2"); // trying to start again
        sessionManager.endSession("user2"); // trying to end a non-existing session
        sessionManager.endSession("user1");
    }
}