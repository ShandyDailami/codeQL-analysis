import java.util.HashMap;
import java.util.Map;

public class java_07180_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07180_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid sessionId: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        System.out.println("User ID: " + sessionManager.getUserId(sessionId));

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}