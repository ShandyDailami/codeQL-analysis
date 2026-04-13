import java.util.HashMap;
import java.util.Map;

public class java_03378_SessionManager_A03 {
    private Map<String, String> sessionMap;
    private Map<String, String> validSessions;

    public java_03378_SessionManager_A03() {
        sessionMap = new HashMap<>();
        validSessions = new HashMap<>();
    }

    // Session creation method
    public String createSession(String user) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        validSessions.put(user, sessionId);
        return sessionId;
    }

    // Session validation method
    public String validateSession(String sessionId, String user) {
        if (sessionMap.containsKey(sessionId) && sessionMap.get(sessionId).equals(user)
                && validSessions.containsKey(user) && validSessions.get(user).equals(sessionId)) {
            return sessionId;
        }
        return null;
    }

    // Session destruction method
    public void destroySession(String sessionId) {
        String user = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        validSessions.remove(user);
    }
}