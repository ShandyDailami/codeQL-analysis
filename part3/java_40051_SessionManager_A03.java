import java.util.HashMap;
import java.util.Map;

public class java_40051_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_40051_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new IllegalStateException("Session already started for user " + username);
        }
        String sessionId = createSessionId();
        sessionMap.put(username, sessionId);
        System.out.println("Session started for user " + username + ". Session ID: " + sessionId);
    }

    public String getSession(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new IllegalStateException("No session started for user " + username);
        }
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new IllegalStateException("No session started for user " + username);
        }
        String sessionId = sessionMap.get(username);
        sessionMap.remove(username);
        System.out.println("Session ended for user " + username + ". Session ID: " + sessionId);
    }

    private String createSessionId() {
        // You can implement this method to generate a unique session ID
        // You can use a UUID or any other method to generate a secure session ID
        return "sessionID";
    }
}