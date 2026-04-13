import java.util.HashMap;
import java.util.Map;

public class java_22982_SessionManager_A07 {
    // Using a HashMap for simplicity, in a real application you'd use a database or some other form of storage
    private Map<String, String> sessionMap;

    public java_22982_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a session key and store it in the map
        String sessionKey = "A07_Session_" + userId;
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    public String getUserIdFromSession(String sessionKey) {
        // Retrieve the userId from the session key
        return sessionMap.get(sessionKey);
    }

    public void deleteSession(String sessionKey) {
        // Delete the session from the map
        sessionMap.remove(sessionKey);
    }

    public boolean isValidSession(String sessionKey) {
        // Check if the session key exists in the map
        return sessionMap.containsKey(sessionKey);
    }
}