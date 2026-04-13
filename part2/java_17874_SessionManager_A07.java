import java.util.HashMap;
import java.util.Map;

public class java_17874_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17874_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user " + username + ". Session ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username != null) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session for user " + username + ". Session ID: " + sessionId);
        } else {
            System.out.println("No active session found for session ID: " + sessionId);
        }
    }

    private String generateSessionId() {
        // This is a simple random session ID generator. In a real-world application, you should use a more secure method.
        return String.valueOf((int) (Math.random() * 10000));
    }
}