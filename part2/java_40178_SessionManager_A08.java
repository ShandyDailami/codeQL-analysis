import java.util.HashMap;
import java.util.Map;

public class java_40178_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_40178_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId); // Outputs: User ID: user1

        sessionManager.endSession("session1");
        userId = sessionManager.getUserId("session1");
        System.out.println("User ID after end session: " + userId); // Outputs: User ID after end session: null
    }
}