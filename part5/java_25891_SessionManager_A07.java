import java.util.HashMap;
import java.util.Map;

public class java_25891_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_25891_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user " + userName + " with ID " + sessionId);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user " + userName + " with ID " + sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for generating a session ID. The actual implementation can depend on your requirements.
        return "A07_AuthFailure";
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Alice");
        sessionManager.startSession("Bob");
        sessionManager.endSession("A07_AuthFailure");
    }
}