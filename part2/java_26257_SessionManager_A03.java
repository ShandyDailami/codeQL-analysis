import java.util.HashMap;
import java.util.Map;

public class java_26257_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26257_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user: " + userName + ", Session ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + userName + ", Session ID: " + sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder implementation, real implementations should generate a secure session ID
        return "A03_Injection";
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("User1");
        sessionManager.startSession("User2");
        sessionManager.endSession("A03_Injection"); // This should print "Session ended for user: User2, Session ID: A03_Injection"
    }
}