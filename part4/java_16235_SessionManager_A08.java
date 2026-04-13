import java.util.HashMap;
import java.util.Map;

public class java_16235_SessionManager_A08 {
    // Define a Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_16235_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Here we're using a placeholder method to validate the session. In reality, you'd use a secure method to validate the session.
        // For example, you could hash the sessionId and compare it to a stored hash.
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            return userId;
        } else {
            // Handle the case where the session is not valid
            System.out.println("Invalid session");
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}