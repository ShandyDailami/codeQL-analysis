import java.util.HashMap;
import java.util.Map;

public class java_10136_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_10136_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (isSessionActive(userId)) {
            System.out.println("Session already active for user: " + userId);
        } else {
            sessionMap.put(userId, "Session active");
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (isSessionActive(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }

    public String getSession(String userId) {
        return sessionMap.getOrDefault(userId, null);
    }

    private boolean isSessionActive(String userId) {
        return sessionMap.containsKey(userId);
    }
}