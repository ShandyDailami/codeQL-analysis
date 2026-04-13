import java.util.HashMap;
import java.util.Map;

public class java_27195_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_27195_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Starts a session
    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new RuntimeException("Session already exists for the user: " + userId);
        }
        sessionMap.put(userId, "Active");
    }

    // Ends a session
    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for the user: " + userId);
        }
        sessionMap.put(userId, "Inactive");
    }

    // Checks if a session exists for the user
    public boolean isSessionActive(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for the user: " + userId);
        }
        return sessionMap.get(userId).equals("Active");
    }
}