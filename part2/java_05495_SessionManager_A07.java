import java.util.HashMap;
import java.util.Map;

public class java_05495_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05495_SessionManager_A07() {
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
}

public class AuthFailure {
    private SessionManager sessionManager;

    public java_05495_SessionManager_A07() {
        sessionManager = new SessionManager();
    }

    public void login(String sessionId, String userId) {
        sessionManager.createSession(sessionId, userId);
    }

    public String auth(String sessionId) {
        return sessionManager.getUserId(sessionId);
    }

    public void logout(String sessionId) {
        sessionManager.deleteSession(sessionId);
    }
}