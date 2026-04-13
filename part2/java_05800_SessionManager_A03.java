import java.util.HashMap;
import java.util.Map;

public class java_05800_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_05800_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session
        sessionManager.startSession("session1", "user1");

        // Get user from session
        String user = sessionManager.getUserFromSession("session1");
        System.out.println("User: " + user); // Outputs: User: user1

        // End a session
        sessionManager.endSession("session1");
    }
}