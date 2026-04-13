import java.util.HashMap;
import java.util.Map;

public class java_37719_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_37719_SessionManager_A01() {
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

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newSessionValue) {
        if (isSessionActive(sessionId)) {
            sessionMap.put(sessionId, newSessionValue);
        } else {
            System.out.println("Session not found.");
        }
    }
}