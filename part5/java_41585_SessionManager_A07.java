import java.util.HashMap;
import java.util.Map;

public class java_41585_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41585_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        System.out.println("Started session: " + sessionId + " for user: " + username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session: " + sessionId + " for user: " + username);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session
        sessionManager.startSession("User1");

        // Get the username from the session
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        // End the session
        sessionManager.endSession(sessionId);
    }
}