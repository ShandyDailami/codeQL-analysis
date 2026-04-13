import java.util.HashMap;
import java.util.Map;

public class java_28151_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_28151_SessionManager_A03() {
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

    public void updateSession(String sessionId, String newValue) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        }
    }

}