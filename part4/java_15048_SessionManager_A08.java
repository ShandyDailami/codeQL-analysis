import java.util.HashMap;
import java.util.Map;

public class java_15048_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_15048_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean integrityFailure(String userId, String expectedSessionId) {
        String sessionId = sessionMap.get(userId);

        // A08_IntegrityFailure: sessionId is null
        if (sessionId == null) {
            return true;
        }

        // A08_IntegrityFailure: sessionId has been changed
        if (!sessionId.equals(expectedSessionId)) {
            return true;
        }

        // A08_IntegrityFailure: sessionId is expired
        // For simplicity, let's assume a session is valid for 1 hour
        if (sessionMap.get(userId).equals("expired")) {
            return true;
        }

        return false;
    }
}