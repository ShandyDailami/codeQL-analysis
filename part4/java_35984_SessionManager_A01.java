import java.util.HashMap;
import java.util.Map;

public class java_35984_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_35984_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}