import java.util.HashMap;
import java.util.Map;

public class java_20801_SessionManager_A07 {
    // Using a HashMap for session storage.
    private Map<String, String> sessionMap;

    public java_20801_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Here, we're assuming that userId is used as a session key.
        // In a real-world application, it would likely be a hash of the user's data.
        // Also, in a real-world application, we'd want to prevent session hijacking.
        String sessionKey = userId;
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    // Method to get a session
    public String getSession(String sessionKey) {
        // Here, we're assuming that the sessionKey is a session identifier.
        // In a real-world application, it would likely be a hash of the session key.
        // Also, in a real-world application, we'd want to prevent session hijacking.
        return sessionMap.get(sessionKey);
    }

    // Method to destroy a session
    public void destroySession(String sessionKey) {
        sessionMap.remove(sessionKey);
    }
}