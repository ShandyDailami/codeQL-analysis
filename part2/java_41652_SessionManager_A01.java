import java.util.HashMap;
import java.util.Map;

public class java_41652_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_41652_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSessionData(String sessionId, String newSessionData) {
        if (isSessionActive(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        } else {
            System.out.println("Session not found. Cannot update session data.");
        }
    }
}