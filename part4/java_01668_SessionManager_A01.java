import java.util.HashMap;
import java.util.Map;

public class java_01668_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_01668_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Invalid session id");
        }
    }

    public void destroySession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("Invalid session id");
        }
    }
}