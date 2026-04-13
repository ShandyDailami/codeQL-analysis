import java.util.HashMap;

public class java_42064_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_42064_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method for starting a session
    public String startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method for validating a session
    public boolean validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            // Add security measures like checking against a known username and password
            if (username.equals("sysadmin") && sessionId.equals("12345")) {
                return true;
            }
        }
        return false;
    }

    // Generates a random session ID
    private String generateSessionId() {
        // This is a simplified example, in a real-world application, you should use a UUID
        // or a similar method to generate a unique ID for each session
        return String.valueOf(System.currentTimeMillis());
    }
}