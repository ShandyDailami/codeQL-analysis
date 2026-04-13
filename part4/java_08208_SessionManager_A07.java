import java.util.HashMap;

public class java_08208_SessionManager_A07 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_08208_SessionManager_A07() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = null;

        // Create a sessionId using username and current timestamp
        // For the simplicity, we are using username as sessionId
        sessionId = username;

        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void updateUser(String sessionId, String newUsername) {
        if (sessionMap.containsKey(sessionId)) {
            // Update user in user map
            userMap.put(sessionId, newUsername);
        }
    }

    public void authFailure(String sessionId) {
        // Authentication failure. Remove session and user from maps.
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            userMap.remove(sessionId);
        }
    }
}