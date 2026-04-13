import java.util.HashMap;
import java.util.Map;

public class java_20854_SessionManager_A07 {

    // Create a HashMap to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_20854_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Invalid session Id");
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeException("Invalid session Id");
        }
    }
}