import java.util.HashMap;
import java.util.Map;

public class java_42066_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_42066_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}