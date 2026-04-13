import java.util.HashMap;
import java.util.Map;

public class java_13525_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_13525_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        manager.createSession("session1", "user1");

        // Validate the session
        boolean isValid = manager.isValidSession("session1");
        System.out.println("Is valid session? " + isValid);

        // Get user id from session
        String userId = manager.getUserIdFromSession("session1");
        System.out.println("User ID: " + userId);

        // End the session
        manager.endSession("session1");
    }
}