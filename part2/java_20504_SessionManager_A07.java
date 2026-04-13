import java.util.HashMap;
import java.util.Map;

public class java_20504_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_20504_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session for user 'user1'
        sessionManager.startSession("user1");

        // End the session for user 'user1'
        sessionManager.endSession("user1");

        // Check the session status for user 'user1'
        System.out.println(sessionManager.getSessionStatus("user1")); // Output: Active
    }
}