import java.util.HashMap;
import java.util.Map;

public class java_03728_SessionManager_A03 {

    // Using a HashMap to simulate a database
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // assuming unique userId for each session
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}