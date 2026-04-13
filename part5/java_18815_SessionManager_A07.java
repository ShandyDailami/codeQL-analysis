import java.util.HashMap;
import java.util.Map;

public class java_18815_SessionManager_A07 {

    // Map to store session IDs and objects
    private Map<String, Object> sessionMap;

    public java_18815_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(Object obj) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, obj);
        return sessionId;
    }

    // Method to get an object from a session
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to stop a session
    public void stopSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Security-sensitive operation: Authentication
    public boolean authenticate(String sessionId, String password) {
        Object obj = sessionMap.get(sessionId);
        // Check if the object is null or not of type User
        if (obj == null || !(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        // Compare the passwords for authentication
        return user.getPassword().equals(password);
    }

    // Security-sensitive operation: Authorization
    public boolean authorize(String sessionId, String action) {
        Object obj = sessionMap.get(sessionId);
        // Check if the object is null or not of type User
        if (obj == null || !(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        // Check if the user has the necessary permissions for the action
        return user.getPermissions().contains(action);
    }
}