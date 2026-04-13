import java.util.HashMap;
import java.util.Map;

public class java_13258_SessionManager_A08 {

    private Map<String, String> sessions;

    public java_13258_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        sessions.put(userId, "started");
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public String getSessionState(String userId) {
        return sessions.get(userId);
    }

    public boolean isSessionActive(String userId) {
        return sessions.containsKey(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session for user "user1"
        sessionManager.startSession("user1");

        // Check if session is active
        if (sessionManager.isSessionActive("user1")) {
            System.out.println("Session for user1 is active");
        } else {
            System.out.println("No active session for user1");
        }

        // End the session for user "user1"
        sessionManager.endSession("user1");

        // Check if session is still active
        if (sessionManager.isSessionActive("user1")) {
            System.out.println("Session for user1 is still active");
        } else {
            System.out.println("No active session for user1");
        }
    }
}