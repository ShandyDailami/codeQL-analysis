import java.util.HashMap;

public class java_02530_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_02530_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = null;
        if(!sessionMap.containsKey(userId)) {
            sessionId = generateSessionId();
            sessionMap.put(userId, sessionId);
        }
        return sessionId;
    }

    // Method to access a session
    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    // Method to terminate a session
    public void terminateSession(String userId) {
        if(sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        }
    }

    // Generate a session ID for a user
    private String generateSessionId() {
        // This method should generate a unique session ID
        // for the user. For simplicity, let's return a fixed ID.
        return "A01_BrokenAccessControl";
    }
}