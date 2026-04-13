import java.util.HashMap;
import java.util.Map;

public class java_01329_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_01329_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}