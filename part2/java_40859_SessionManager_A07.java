import java.util.HashMap;
import java.util.Map;

public class java_40859_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40859_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void authenticate(String sessionId, String password) {
        String userId = sessionMap.get(sessionId);

        if (userId == null || !userId.equals(password)) {
            throw new AuthFailureException();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session for user with ID 'user1'
        sessionManager.startSession("session1", "user1");

        // Authenticate as user 'user1' with password 'password1'
        sessionManager.authenticate("session1", "password1");

        // Get the user ID for the session 'session1'
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId); // Should print 'user1'

        // End the session 'session1'
        sessionManager.endSession("session1");
    }
}