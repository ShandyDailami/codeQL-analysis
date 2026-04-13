import java.util.HashMap;
import java.util.Map;

public class java_39094_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_39094_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
            return null;
        } else {
            sessionMap.put(sessionId, "Session data for " + sessionId);
            System.out.println("Session created with id: " + sessionId);
            return sessionMap.get(sessionId);
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session found with id: " + sessionId);
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session does not exist with id: " + sessionId);
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted with id: " + sessionId);
        } else {
            System.out.println("Session does not exist with id: " + sessionId);
        }
    }
}