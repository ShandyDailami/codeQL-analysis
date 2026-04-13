import java.util.HashMap;
import java.util.Map;

public class java_14679_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_14679_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        System.out.println("Starting session for user: " + userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Ending session for user: " + userId);
        } else {
            System.out.println("Invalid session ID.");
        }
    }

    private String generateSessionId() {
        // This is a simple method of generating a session id, it's not secure and not recommended for production usage
        return "SessionID" + System.currentTimeMillis();
    }

    // Method for validating user credentials
    public boolean validateUser(String userId, String password) {
        // This is a simple method of validating user credentials, it's not secure and not recommended for production usage
        return userId.equals(password);
    }
}