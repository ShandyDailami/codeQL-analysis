import java.util.HashMap;
import java.util.Map;

public class java_21313_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_21313_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // Add the session to the session map
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        // Retrieve the user id associated with the session
        return sessionMap.get(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        // Check if the session is valid
        return sessionMap.containsKey(sessionId);
    }
}