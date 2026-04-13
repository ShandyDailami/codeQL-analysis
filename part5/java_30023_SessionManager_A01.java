import java.util.HashMap;
import java.util.Map;

public class java_30023_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30023_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID: " + sessionId + " already exists, cannot start.");
        } else {
            sessionMap.put(sessionId, username);
            System.out.println("Session started with ID: " + sessionId + " for user: " + username);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID: " + sessionId + " does not exist, cannot end.");
        } else {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
        }
    }

    public String getUser(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID: " + sessionId + " does not exist.");
            return null;
        } else {
            return sessionMap.get(sessionId);
        }
    }
}