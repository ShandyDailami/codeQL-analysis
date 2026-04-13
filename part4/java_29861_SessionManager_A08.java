import java.util.HashMap;
import java.util.Map;

public class java_29861_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_29861_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
            System.out.println("Session " + sessionId + " started for user " + userId);
        } else {
            System.out.println("Session " + sessionId + " already exists");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " ended for user " + userId);
        } else {
            System.out.println("No session " + sessionId + " to end");
        }
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        sessionManager.startSession("s1", "u1");
        sessionManager.startSession("s2", "u2");
        sessionManager.startSession("s1", "u3"); // Should fail as session s1 already exists
        sessionManager.endSession("s1");
        sessionManager.endSession("s4"); // Should fail as no session s4 to end
    }
}