import java.util.HashMap;
import java.util.Map;

public class java_33373_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33373_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = "session_" + username;
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user: " + username);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username != null) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session for user: " + username);
        } else {
            System.out.println("No active session found for session ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("user1");
        sessionManager.startSession("user2");
        sessionManager.endSession("session_user1");
        sessionManager.endSession("invalidSessionId");
    }
}