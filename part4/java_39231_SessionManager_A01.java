import java.util.HashMap;
import java.util.Map;

public class java_39231_SessionManager_A01 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Default Constructor
    public java_39231_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            return "Session ID cannot be null or empty";
        } else {
            sessionMap.put(sessionId, "Created");
            return "Session Created Successfully with ID: " + sessionId;
        }
    }

    // Method to validate session
    public String validateSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            return "Session ID cannot be null or empty";
        } else {
            if (sessionMap.containsKey(sessionId) && sessionMap.get(sessionId).equals("Created")) {
                return "Session Validated Successfully";
            } else {
                return "Invalid Session ID";
            }
        }
    }

    // Method to destroy session
    public String destroySession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            return "Session ID cannot be null or empty";
        } else {
            if (sessionMap.containsKey(sessionId)) {
                sessionMap.remove(sessionId);
                return "Session Destroyed Successfully";
            } else {
                return "Invalid Session ID";
            }
        }
    }
}