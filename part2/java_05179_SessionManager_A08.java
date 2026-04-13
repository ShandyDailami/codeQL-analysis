import java.util.HashMap;
import java.util.Map;

public class java_05179_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05179_SessionManager_A08() {
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

    public void handleIntegrityFailure(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            if (userId == null) {
                // User has been deleted, remove session
                deleteSession(sessionId);
            } else {
                // User has been updated, invalidate session
                invalidateSession(sessionId);
            }
        } else {
            // Session not found, nothing to do
        }
    }

    private void invalidateSession(String sessionId) {
        // Invalidate session here
        System.out.println("Invalidating session: " + sessionId);
    }
}