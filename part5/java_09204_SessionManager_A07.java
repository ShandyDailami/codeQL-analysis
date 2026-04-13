import java.util.HashMap;
import java.util.Map;

public class java_09204_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_09204_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        System.out.println("Session " + sessionId + " started for user " + username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " ended for user " + username);
        }
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        sessionManager.startSession("Alice");
        sessionManager.startSession("Bob");

        String aliceSessionId = sessionManager.getUsername("12345"); // Alice's session ID
        String bobSessionId = sessionManager.getUsername("ABCDE"); // Bob's session ID

        sessionManager.endSession(aliceSessionId);
        sessionManager.endSession(bobSessionId);
    }
}