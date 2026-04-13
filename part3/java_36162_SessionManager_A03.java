import java.util.HashMap;
import java.util.Map;

public class java_36162_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36162_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session already exists for user: " + userId);
        } else {
            sessionMap.put(userId, "Session active");
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session exists for user: " + userId);
        }
    }

    public String validateSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId)) {
            System.out.println("Session validated for user: " + userId);
            return "Session active";
        } else {
            System.out.println("Invalid session or no session exists for user: " + userId);
            return null;
        }
    }
}