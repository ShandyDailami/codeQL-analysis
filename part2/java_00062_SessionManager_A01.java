import java.util.HashMap;
import java.util.Map;

public class java_00062_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_00062_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}