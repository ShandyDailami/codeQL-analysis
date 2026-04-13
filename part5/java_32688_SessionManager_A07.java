import java.util.HashMap;
import java.util.Map;

public class java_32688_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_32688_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid sessionId");
        }
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new AuthFailureException("Invalid sessionId");
        }
    }
}