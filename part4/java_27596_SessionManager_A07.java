import java.util.HashMap;
import java.util.Map;

public class java_27596_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27596_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Function to create a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Function to get the userId from a session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Function to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Function to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}