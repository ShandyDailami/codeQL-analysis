import java.util.HashMap;
import java.util.Map;

public class java_11747_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11747_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        LegacySessionManager manager = new LegacySessionManager();

        manager.startSession("user1", "session1");
        String userId = manager.getUserId("session1");
        System.out.println("User ID: " + userId);

        manager.startSession("user2", "session2");
        userId = manager.getUserId("session2");
        System.out.println("User ID: " + userId);

        manager.endSession("session2");
        userId = manager.getUserId("session2");
        System.out.println("User ID: " + userId);
    }
}