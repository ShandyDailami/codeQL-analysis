import java.util.LinkedHashMap;
import java.util.Map;

public class java_01942_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_01942_SessionManager_A03() {
        sessionMap = new LinkedHashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}