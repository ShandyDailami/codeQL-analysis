import java.util.HashMap;
import java.util.Map;

public class java_22843_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22843_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started with ID " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID " + sessionId + " for user " + userId);
        } else {
            System.out.println("No session with ID " + sessionId + " found.");
        }
    }
}