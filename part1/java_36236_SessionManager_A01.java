import java.util.HashMap;
import java.util.Map;

public class java_36236_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_36236_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        // Create a session for the given user
        String sessionId = "SESSION_" + user.hashCode();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        // Retrieve the user corresponding to the given session
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Delete the session corresponding to the given session
        sessionMap.remove(sessionId);
    }

    public boolean checkAccess(String sessionId) {
        // Check if the session is valid
        return sessionMap.containsKey(sessionId);
    }
}