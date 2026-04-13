import java.util.HashMap;
import java.util.Map;

public class java_08432_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_08432_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session " + sessionId + " started by user " + userId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended by user " + userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");
        sessionManager.endSession("session1");
        sessionManager.endSession("session2");
    }
}