import java.util.HashMap;
import java.util.Map;

public class java_38589_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_38589_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Check if the session is valid
    public boolean isSessionValid(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            // If sessionId exists in the map, return true
            return true;
        } else {
            // If sessionId does not exist in the map, return false
            return false;
        }
    }

    // Create a session
    public String createSession(String user) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Get the user from the session
    public String getUserFromSession(String sessionId) {
        if (isSessionValid(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Handle integrity failure here. For example, throw an exception
            throw new SecurityException("Session integrity failure");
        }
    }

    // Update the user in the session
    public void updateUserInSession(String sessionId, String user) {
        if (isSessionValid(sessionId)) {
            sessionMap.put(sessionId, user);
        } else {
            // Handle integrity failure here. For example, throw an exception
            throw new SecurityException("Session integrity failure");
        }
    }

    // Delete the session
    public void deleteSession(String sessionId) {
        if (isSessionValid(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            // Handle integrity failure here. For example, throw an exception
            throw new SecurityException("Session integrity failure");
        }
    }
}