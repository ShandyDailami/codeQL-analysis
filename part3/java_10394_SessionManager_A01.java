import java.util.HashMap;
import java.util.Map;

public class java_10394_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_10394_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session id");
        }
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session id");
        }
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session id");
        }
        sessionMap.replace(sessionId, newSessionData);
    }
}