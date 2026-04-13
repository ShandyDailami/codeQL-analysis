import java.util.HashMap;
import java.util.Map;

public class java_41642_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_41642_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void updateSession(String sessionId, String value) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, value);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}