import java.util.HashMap;
import java.util.Map;

public class java_31070_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_31070_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "active");
    }

    public void endSession(String username) {
        sessionMap.put(username, "inactive");
    }

    public boolean isSessionActive(String username) {
        String status = sessionMap.get(username);
        return "active".equals(status);
    }

    public static void main(String[] args) {
        AuthFailureSessionManager sessionManager = new AuthFailureSessionManager();

        sessionManager.startSession("user1");
        sessionManager.startSession("user2");
        sessionManager.startSession("user3");

        // Attempts to access as user1 and user4
        System.out.println(sessionManager.isSessionActive("user1")); // Expected: true
        System.out.println(sessionManager.isSessionActive("user4")); // Expected: false

        // End sessions
        sessionManager.endSession("user1");
        sessionManager.endSession("user4");

        // Check the status of sessions after ending
        System.out.println(sessionManager.isSessionActive("user1")); // Expected: false
        System.out.println(sessionManager.isSessionActive("user4")); // Expected: false
    }
}