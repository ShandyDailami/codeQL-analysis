import java.util.HashMap;
import java.util.Map;

public class java_35935_SessionManager_A08 {
    private Map<String, String> sessionData;

    public java_35935_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (isValidSessionId(sessionId)) {
            sessionData.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (isValidSessionId(sessionId)) {
            return sessionData.get(sessionId);
        }
        return null;
    }

    public void destroySession(String sessionId) {
        if (isValidSessionId(sessionId)) {
            sessionData.remove(sessionId);
        }
    }

    private boolean isValidSessionId(String sessionId) {
        // Implement your security logic here to check if the session id is valid
        // For example, you can check if the session id is not null and if the session data exists in the session data map
        return sessionId != null && sessionData.containsKey(sessionId);
    }
}