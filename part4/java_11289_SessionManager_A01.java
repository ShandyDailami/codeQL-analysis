import java.util.HashMap;
import java.util.Map;

public class java_11289_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_11289_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}