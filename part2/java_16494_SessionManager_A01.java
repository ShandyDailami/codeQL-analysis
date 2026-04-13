import java.util.HashMap;
import java.util.Map;

public class java_16494_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16494_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Create session key from username
        String sessionKey = username;
        // Store session key and username in session map
        sessionMap.put(sessionKey, username);
    }

    public void endSession(String username) {
        // Get session key from username
        String sessionKey = username;
        // Remove session key and username from session map
        sessionMap.remove(sessionKey);
    }

    public String getUsername(String sessionKey) {
        // Retrieve username from session key
        return sessionMap.get(sessionKey);
    }
}