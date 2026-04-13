import java.util.HashMap;
import java.util.Map;

public class java_26668_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26668_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}