import java.util.HashMap;
import java.util.Map;

public class java_03863_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03863_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start session
    public String startSession(String userId) {
        String sessionId = String.valueOf(System.nanoTime());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to check if session is valid
    public boolean checkSession(String sessionId, String expectedUserId) {
        if (!sessionMap.containsKey(sessionId)) {
            // This operation is security-sensitive and should not be used in real-world applications
            System.out.println("Invalid session ID: " + sessionId);
            return false;
        }

        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            System.out.println("Session ID has null user ID: " + sessionId);
            return false;
        }

        if (!userId.equals(expectedUserId)) {
            System.out.println("Invalid user ID in session: " + sessionId);
            return false;
        }

        return true;
    }

    // Method to end session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}