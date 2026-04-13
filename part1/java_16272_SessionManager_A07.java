import java.util.HashMap;
import java.util.Map;

public class java_16272_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16272_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = "123";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get the user from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User: " + user);

        // Remove the session
        sessionManager.removeSession(sessionId);
    }
}