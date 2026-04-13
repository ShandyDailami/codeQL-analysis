import java.util.HashMap;
import java.util.Map;

public class java_00066_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_00066_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session ID");
        }
    }

    public void invalidateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session ID");
        }
    }

    public void checkIntegrity() {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (!entry.getValue().equals(getUserId(entry.getKey()))) {
                throw new SecurityFailureException("Session integrity failure for session ID: " + entry.getKey());
            }
        }
    }
}