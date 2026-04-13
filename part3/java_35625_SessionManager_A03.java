import java.util.HashMap;
import java.util.Map;

public class java_35625_SessionManager_A03 {

    // Create a private instance of HashMap to store session data.
    private Map<String, String> sessionMap = new HashMap<>();

    // Create a method to create a new session.
    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Create a method to retrieve a userId from a session.
    public String getUserIdFromSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid Session ID");
        }
    }

    // Create a method to remove a session.
    public void removeSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid Session ID");
        }
    }
}