import java.util.HashMap;
import java.util.Map;

public class java_06581_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_06581_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for user: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session found for user: " + sessionId);
        }
    }
}