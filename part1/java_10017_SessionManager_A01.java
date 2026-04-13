import java.util.HashMap;
import java.util.Map;

public class java_10017_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_10017_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}