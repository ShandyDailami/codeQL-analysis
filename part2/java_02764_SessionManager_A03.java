import java.util.HashMap;
import java.util.Map;

public class java_02764_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02764_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Started session with id: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session with id: " + sessionId + ", username: " + username);
    }

    private String generateSessionId() {
        // This method is intentionally kept simple for this example.
        // In a real-world application, this could involve more complex logic.
        return Long.toHexString(System.currentTimeMillis() * username.hashCode());
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Alice");
        sessionManager.startSession("Bob");
        sessionManager.endSession("Bob");
        sessionManager.endSession("Alice");
    }
}