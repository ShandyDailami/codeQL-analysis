import java.util.HashMap;
import java.util.Map;

public class java_15170_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_15170_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String value) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, value);
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}