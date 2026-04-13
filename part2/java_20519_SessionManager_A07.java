import java.util.HashMap;
import java.util.Map;

public class java_20519_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20519_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public String getSessionState(String userId) {
        return sessionMap.get(userId);
    }

    public boolean isSessionActive(String userId) {
        String sessionState = getSessionState(userId);
        return sessionState != null && sessionState.equals("Active");
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Starting session
        sessionManager.startSession("user1");

        // Checking session
        if (sessionManager.isSessionActive("user1")) {
            System.out.println("Session is active.");
        } else {
            System.out.println("Session is not active.");
        }

        // Ending session
        sessionManager.endSession("user1");

        // Checking session again
        if (sessionManager.isSessionActive("user1")) {
            System.out.println("Session is active after end session.");
        } else {
            System.out.println("Session is not active after end session.");
        }
    }
}