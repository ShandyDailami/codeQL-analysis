import java.util.HashMap;
import java.util.Map;

public class java_16802_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_16802_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSessionValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Access Denied: Session Id not found");
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}