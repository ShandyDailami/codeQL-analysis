import java.util.HashMap;
import java.util.Map;

public class java_33388_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33388_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        String sessionData = sessionMap.get(sessionId);

        // If session does not exist, return null
        if (sessionData == null) {
            return null;
        }

        // If session exists, remove it from sessionMap
        sessionMap.remove(sessionId);

        return sessionData;
    }

    public void updateSession(String sessionId, String newSessionData) {
        // If session does not exist, return null
        if (getSessionData(sessionId) == null) {
            return;
        }

        sessionMap.replace(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}