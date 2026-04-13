import java.util.HashMap;
import java.util.Map;

public class java_08477_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_08477_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void invalidateSession(String sessionId) {
        deleteSession(sessionId);
    }

    public void sessionExpired(String sessionId) {
        deleteSession(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}