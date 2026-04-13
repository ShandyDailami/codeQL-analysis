import java.util.HashMap;
import java.util.Map;

public class java_25407_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_25407_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionId != null && userId != null) {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionId != null) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        if (sessionId != null) {
            sessionMap.remove(sessionId);
        }
    }

    public void updateSession(String oldSessionId, String newSessionId, String userId) {
        if (oldSessionId != null && newSessionId != null && userId != null) {
            if (sessionMap.containsKey(oldSessionId)) {
                sessionMap.put(newSessionId, sessionMap.get(oldSessionId));
                sessionMap.remove(oldSessionId);
            } else {
                createSession(newSessionId, userId);
            }
        }
    }
}