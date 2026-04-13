import java.util.HashMap;
import java.util.Map;

public class java_10626_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_10626_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUserBySessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public void updateSession(String sessionId, String newUsername) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUsername);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }
}