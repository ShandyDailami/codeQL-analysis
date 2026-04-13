import java.util.HashMap;
import java.util.Map;

public class java_10840_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_10840_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Invalid session ID " + sessionId);
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session for user " + username);
        } else {
            System.out.println("Invalid session ID " + sessionId);
        }
    }
}