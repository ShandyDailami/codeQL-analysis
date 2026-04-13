import java.util.HashMap;
import java.util.Map;

public class java_15430_SessionManager_A03 {
    private Map<String, String> sessionMap;

    // Constructor injection
    public java_15430_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}