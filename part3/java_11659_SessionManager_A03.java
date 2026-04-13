import java.util.HashMap;
import java.util.Map;

public class java_11659_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_11659_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Get the user id from the session
        String userId = sessionManager.getUserIdFromSession("session1");
        System.out.println("User ID: " + userId);

        // Delete a session
        sessionManager.deleteSession("session1");

        // Check if a session is valid
        boolean isValid = sessionManager.isSessionValid("session1");
        System.out.println("Is Valid: " + isValid);
    }
}