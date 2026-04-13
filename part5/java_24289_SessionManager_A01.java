import java.util.HashMap;
import java.util.Map;

public class java_24289_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_24289_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);

        System.out.println("Created session ID: " + sessionId);
        System.out.println("User from session: " + sessionManager.getUserFromSession(sessionId));

        sessionManager.removeSession(sessionId);
        System.out.println("Removed session: " + sessionId);
    }
}