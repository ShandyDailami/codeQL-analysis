import java.util.HashMap;
import java.util.Map;

public class java_05875_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05875_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}