import java.util.HashMap;
import java.util.Map;

public class java_11558_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_11558_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Error: Session already exists for user: " + userId);
        } else {
            sessionMap.put(userId, sessionId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("Error: No session found for user: " + userId);
        }
    }

    public String getSessionId(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            System.out.println("Error: No session found for user: " + userId);
            return null;
        }
    }
}