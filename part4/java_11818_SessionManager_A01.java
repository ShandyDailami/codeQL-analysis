import java.util.HashMap;
import java.util.Map;

public class java_11818_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_11818_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (isSessionExists(sessionId)) {
            sessionMap.replace(sessionId, newSessionData);
        }
    }
}