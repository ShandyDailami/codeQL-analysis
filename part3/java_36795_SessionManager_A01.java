import java.util.HashMap;
import java.util.Map;

public class java_36795_SessionManager_A01 {
    // A map to store sessions.
    private Map<String, String> sessionMap;

    public java_36795_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user for a given session.
    public String getUserForSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to close a session.
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}