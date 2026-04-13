import java.util.HashMap;
import java.util.Map;

public class java_08669_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_08669_SessionManager_A03() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Get user from session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId); // Output: User ID: user1

        // End session
        sessionManager.endSession("session1");

        // Check session validity
        boolean isValid = sessionManager.isValidSession("session1");
        System.out.println("Is Valid Session: " + isValid); // Output: Is Valid Session: false
    }
}