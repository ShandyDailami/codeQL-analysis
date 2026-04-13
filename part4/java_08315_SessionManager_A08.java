import java.util.HashMap;
import java.util.Map;

public class java_08315_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08315_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "User1");

        if (sessionManager.isValidSession("session1")) {
            String username = sessionManager.getUsername("session1");
            System.out.println("Username: " + username);
        } else {
            System.out.println("Invalid session");
        }

        sessionManager.endSession("session1");
    }
}