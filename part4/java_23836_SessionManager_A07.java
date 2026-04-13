import java.util.HashMap;
import java.util.Map;

public class java_23836_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_23836_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) throws SessionNotFoundException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SessionNotFoundException("Session not found");
        }
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class SessionNotFoundException extends Exception {
        public java_23836_SessionManager_A07(String message) {
            super(message);
        }
    }
}