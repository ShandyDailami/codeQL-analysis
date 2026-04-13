import java.util.HashMap;
import java.util.Map;

public class java_02310_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_02310_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        String sessionId = sessionMap.get(userId);

        // Verify integrity (e.g., check if the session exists)
        if (sessionId == null) {
            throw new SecurityException("Integrity failure: Session not found");
        }

        return sessionId;
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }
}