import java.util.HashMap;
import java.util.Map;

public class java_03599_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_03599_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = "SESSION_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        String sessionId = manager.createSession("USER_1");
        System.out.println("Created session: " + sessionId);

        // Get the user id from the session
        String userId = manager.getUserId(sessionId);
        System.out.println("User id from session: " + userId);

        // End the session
        manager.endSession(sessionId);
        System.out.println("Ended session: " + sessionId);
    }
}