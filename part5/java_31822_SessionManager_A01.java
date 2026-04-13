import java.util.HashMap;

public class java_31822_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_31822_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists!";
        } else {
            sessionMap.put(sessionId, sessionId);
            return "Session created successfully!";
        }
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session exists!";
        } else {
            return "Session does not exist!";
        }
    }

    // Method to destroy a session
    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session destroyed successfully!";
        } else {
            return "Session does not exist!";
        }
    }
}