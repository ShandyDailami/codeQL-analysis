import java.util.HashMap;
import java.util.Map;

public class java_35339_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_35339_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userName);
            System.out.println("Session started for user: " + userName);
        } else {
            System.out.println("Session already exists for user: " + sessionMap.get(sessionId));
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("No active session for user: " + sessionMap.get(sessionId));
        }
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "No active session for user: " + sessionMap.get(sessionId);
        }
    }
}