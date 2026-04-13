import java.util.HashMap;
import java.util.Map;

public class java_36384_SessionManager_A03 {
    // Using HashMap to simulate a database.
    private Map<String, String> sessionMap;

    public java_36384_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session.
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}