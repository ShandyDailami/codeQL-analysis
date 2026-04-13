import java.util.HashMap;
import java.util.Map;

public class java_13673_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_13673_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}