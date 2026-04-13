import java.util.HashMap;
import java.util.Map;

public class java_18331_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_18331_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}

public class BrokenAccessControl {
    private SessionManager sessionManager;

    public java_18331_SessionManager_A01() {
        sessionManager = new SessionManager();
    }

    public void createSession(String sessionId, String userId) {
        sessionManager.createSession(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionManager.getUserIdBySessionId(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionManager.deleteSession(sessionId);
    }

    public void deleteAllSessions() {
        sessionManager.deleteAllSessions();
    }
}