import java.util.HashMap;

public class java_32286_SessionManager_A07 {
    // A HashMap to store session data
    private HashMap<String, String> sessionMap;

    public java_32286_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
            return "Session created successfully";
        } else {
            return "Session already exists";
        }
    }

    // Method to validate a session
    public String validateSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            if (sessionMap.get(sessionId).equals(userId)) {
                return "Session validated successfully";
            } else {
                return "Invalid session";
            }
        } else {
            return "Invalid session";
        }
    }

    // Method to destroy a session
    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session destroyed successfully";
        } else {
            return "Invalid session";
        }
    }
}