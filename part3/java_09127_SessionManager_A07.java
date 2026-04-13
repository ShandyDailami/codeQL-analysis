import java.util.HashMap;
import java.util.Map;

public class java_09127_SessionManager_A07 {
    private Map<String, Object> sessionMap;

    public java_09127_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public Object getSessionAttribute(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSessionAttribute(String sessionId, Object attribute) {
        sessionMap.put(sessionId, attribute);
    }

    public void removeSessionAttribute(String sessionId) {
        sessionMap.remove(sessionId);
    }
}