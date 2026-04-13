// Start of code

import java.util.HashMap;
import java.util.Map;

public class java_09116_SessionManager_A08 {
    // A map to store user sessions.
    private Map<String, String> sessionMap;

    // Constructor
    public java_09116_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to add a new session
    public String addSession(String user) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user associated with a session
    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to validate if a session exists
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

// End of code