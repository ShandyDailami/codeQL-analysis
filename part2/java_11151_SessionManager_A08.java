import java.util.HashMap;
import java.util.Map;

public class java_11151_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11151_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session Already Started with ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session Started with ID: " + sessionId + " for User: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session Not Found with ID: " + sessionId);
        } else {
            sessionMap.remove(sessionId);
            System.out.println("Session Ended with ID: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session Not Found with ID: " + sessionId);
            return null;
        } else {
            return sessionMap.get(sessionId);
        }
    }
}