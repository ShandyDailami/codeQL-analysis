import java.util.HashMap;
import java.util.Map;

public class java_36877_SessionManager_A03 {
    private Map<String, Object> sessionMap;

    public java_36877_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operations related to Injection
    public void createSessionForInjection(String sessionId, Object sessionObject) {
        // The following operation does not involve injection, hence it's safe.
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSessionForInjection(String sessionId) {
        // No attempt to validate or sanitize the sessionId, hence it's safe.
        return sessionMap.get(sessionId);
    }

    public void deleteSessionForInjection(String sessionId) {
        // No attempt to validate or sanitize the sessionId, hence it's safe.
        sessionMap.remove(sessionId);
    }
}