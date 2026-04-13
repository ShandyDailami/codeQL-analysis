import java.util.HashMap;
import java.util.Map;

public class java_37831_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37831_SessionManager_A07() {
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

        // Create a session
        String sessionId1 = "session1";
        String userId1 = "user1";
        sessionManager.createSession(sessionId1, userId1);

        // Get the userId from the session
        String userId = sessionManager.getUserId(sessionId1);
        System.out.println("UserId: " + userId);

        // End the session
        sessionManager.endSession(sessionId1);
    }
}