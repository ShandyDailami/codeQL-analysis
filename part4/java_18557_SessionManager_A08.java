import java.util.HashMap;
import java.util.Map;

public class java_18557_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_18557_SessionManager_A08() {
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

    public void updateSession(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        } else {
            System.out.println("Session not found!");
        }
    }

    public boolean containsSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}