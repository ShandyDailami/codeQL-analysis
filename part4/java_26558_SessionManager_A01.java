import java.util.HashMap;
import java.util.Map;

public class java_26558_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_26558_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new IllegalStateException("Session already started for user: " + username);
        }
        String sessionId = createSessionId(username);
        sessionMap.put(sessionId, username);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username == null) {
            throw new IllegalStateException("No session found for sessionId: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String createSessionId(String username) {
        // You can create a session id based on the username or any other unique property.
        // This is a placeholder.
        return username;
    }
}