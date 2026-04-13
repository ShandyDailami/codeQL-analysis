import java.util.HashMap;
import java.util.Map;

public class java_02121_SessionManager_A07 {

    // A map to hold the sessions. This is a very simple way of managing sessions, but it's not suitable for a real-world application.
    private Map<String, String> sessionMap = new HashMap<>();

    // A method to create a session. This is a very basic way of managing sessions, but it's not suitable for a real-world application.
    public String createSession(String userId) {
        // Generate a unique session ID
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // A method to get a user ID from a session. This is a very basic way of managing sessions, but it's not suitable for a real-world application.
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // A method to validate a session. This is a very basic way of managing sessions, but it's not suitable for a real-world application.
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}