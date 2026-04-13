import java.util.HashMap;

public class java_30642_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_30642_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Get the user id from a session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}