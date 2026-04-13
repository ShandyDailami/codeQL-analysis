import java.util.HashMap;
import java.util.Map;

public class java_14851_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_14851_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void updateSessionValue(String sessionId, String newValue) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }
        sessionMap.put(sessionId, newValue);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "value1");
        sessionManager.createSession("session2", "value2");

        System.out.println("Value of session1: " + sessionManager.getSessionValue("session1"));
        System.out.println("Value of session2: " + sessionManager.getSessionValue("session2"));

        sessionManager.updateSessionValue("session1", "newValue1");
        System.out.println("Value of session1 after update: " + sessionManager.getSessionValue("session1"));

        sessionManager.deleteSession("session2");
        System.out.println("Value of session2 after deletion: " + sessionManager.getSessionValue("session2"));
    }
}