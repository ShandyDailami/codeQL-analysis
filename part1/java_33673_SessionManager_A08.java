import java.util.HashMap;
import java.util.Map;

public class java_33673_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_33673_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void invalidateSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}