import java.util.HashMap;
import java.util.Map;

public class java_13032_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_13032_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String userId = "user1";
        String sessionId = "session1";
        sessionManager.createSession(userId, sessionId);

        // Get the userId associated with the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User: " + user); // Outputs: User: user1

        // Delete the session
        sessionManager.deleteSession(sessionId);

        // Attempt to get the userId after deleting the session
        user = sessionManager.getUserId(sessionId);
        System.out.println("User: " + user); // Outputs: User: null
    }
}