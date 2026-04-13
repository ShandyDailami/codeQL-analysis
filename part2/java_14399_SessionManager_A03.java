import java.util.HashMap;
import java.util.Map;

public class java_14399_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_14399_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}