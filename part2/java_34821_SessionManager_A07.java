import java.util.HashMap;
import java.util.Map;

public class java_34821_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_34821_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session: " + sessionId);

        // Get the user from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User from session: " + user);

        // Remove the session
        sessionManager.removeSession(sessionId);
        System.out.println("Removed session: " + sessionId);
    }
}