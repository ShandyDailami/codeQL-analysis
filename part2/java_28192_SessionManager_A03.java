import java.util.HashMap;

public class java_28192_SessionManager_A03 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap = new HashMap<>();

    // This is a basic session creation method
    public String createSession(String username) {
        String sessionId = "session-" + System.currentTimeMillis();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // This is a basic session validation method
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // This is a basic session removal method
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}