import java.util.HashMap;
import java.util.Map;

public class java_23924_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_23924_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a new session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Authenticate and authorize the user
        if (sessionManager.isValidSession(sessionId)) {
            String user = sessionManager.getUserId(sessionId);
            System.out.println("User authenticated and authorized: " + user);
        } else {
            System.out.println("Invalid session or no session found");
        }

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}