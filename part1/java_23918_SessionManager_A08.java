import java.util.HashMap;
import java.util.Map;

public class java_23918_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_23918_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String sessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionValue);
        } else {
            System.out.println("No such session found to update");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No such session found to delete");
        }
    }

    public void clearAllSessions() {
        sessionMap.clear();
    }

    public void checkSessionIntegrity() {
        if (sessionMap.isEmpty()) {
            System.out.println("No sessions found, integrity check passed");
        } else {
            System.out.println("Found unsafe sessions, integrity check failed");
        }
    }
}