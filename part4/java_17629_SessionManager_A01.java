import java.util.HashMap;
import java.util.Map;

public class java_17629_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_17629_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "No session found";
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void updateSessionData(String sessionId, String newData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newData);
        }
    }
}