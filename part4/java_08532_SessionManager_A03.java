import java.util.HashMap;
import java.util.Map;

public class java_08532_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_08532_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}