import java.util.HashMap;
import java.util.Map;

public class java_31113_SessionManager_A07 {

    // A map to hold sessions
    private Map<String, String> sessionMap;

    public java_31113_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId for a given session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate if a session is valid
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to invalidate all sessions for a user
    public void invalidateUserSessions(String userId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                endSession(entry.getKey());
            }
        }
    }
}