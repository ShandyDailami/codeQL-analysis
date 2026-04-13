import java.util.HashMap;
import java.util.Map;

public class java_28244_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28244_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new IllegalStateException("Session already exists for user: " + username);
        }
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(username, sessionId);
        System.out.println("Started session for user: " + username);
    }

    public void endSession(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new IllegalStateException("No session exists for user: " + username);
        }
        sessionMap.remove(username);
        System.out.println("Ended session for user: " + username);
    }

    public boolean validateSession(String username, String sessionId) {
        if (!sessionMap.containsKey(username)) {
            throw new IllegalStateException("No session exists for user: " + username);
        }
        return sessionMap.get(username).equals(sessionId);
    }
}