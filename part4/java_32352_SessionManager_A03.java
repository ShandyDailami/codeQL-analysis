import java.util.HashMap;
import java.util.Map;

public class java_32352_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_32352_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}