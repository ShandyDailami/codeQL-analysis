import java.util.HashMap;
import java.util.Map;

public class java_22849_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22849_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Session " + sessionId + " started for user " + username);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + username);
    }

    private String generateSessionId() {
        // This is a placeholder, in a real scenario you would generate a unique id
        // You can use UUID or some other method to generate a random session id
        return "sessionId";
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start session
        sessionManager.startSession("John");

        // End session
        sessionManager.endSession("sessionId");
    }
}