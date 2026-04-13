import java.util.HashMap;
import java.util.Map;

public class java_36167_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_36167_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new IllegalStateException("Session already exists for user " + username);
        }
        String sessionId = generateSessionId();
        sessionMap.put(username, sessionId);
        System.out.println("Session started for user " + username + ". Session ID: " + sessionId);
    }

    public void endSession(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new IllegalStateException("No session found for user " + username);
        }
        String sessionId = sessionMap.get(username);
        sessionMap.remove(username);
        System.out.println("Session ended for user " + username + ". Session ID: " + sessionId);
    }

    private String generateSessionId() {
        // This is a simplified example, in a real application you would use a UUID or similar
        return "sessionId" + System.nanoTime();
    }
}