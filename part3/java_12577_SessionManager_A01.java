import java.util.HashMap;
import java.util.Map;

public class java_12577_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private String activeSession;

    public java_12577_SessionManager_A01() {
        sessionMap = new HashMap<>();
        activeSession = null;
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        activeSession = sessionId;
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionId != null && sessionMap.containsKey(sessionId)) {
            activeSession = sessionId;
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        if (sessionId != null && sessionMap.containsKey(sessionId)) {
            activeSession = null;
            sessionMap.remove(sessionId);
        }
    }

    private String generateSessionId() {
        // This is a simple example of a session ID generation, it's not secure and should not be used in a production environment
        return String.valueOf(System.currentTimeMillis());
    }

    public String getActiveSession() {
        return activeSession;
    }

    public boolean isSessionActive(String sessionId) {
        return sessionId != null && sessionMap.containsKey(sessionId) && (activeSession != null && activeSession.equals(sessionId));
    }
}