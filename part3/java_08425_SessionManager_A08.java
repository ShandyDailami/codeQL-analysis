import java.util.HashMap;
import java.util.Map;

public class java_08425_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_08425_SessionManager_A08() {
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

        // Create a session
        String sessionId = "123";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get user ID
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User ID: " + user);

        // Validate session
        boolean isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is Valid Session: " + isValid);

        // Delete session
        sessionManager.deleteSession(sessionId);
        isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is Valid Session After Deletion: " + isValid);
    }
}