import java.util.HashMap;
import java.util.Map;

public class java_40138_SessionManager_A07 {

    // A simple in-memory storage for session data
    private Map<String, String> sessionStorage;

    public java_40138_SessionManager_A07() {
        sessionStorage = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // Validate userId to ensure it's a real user
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null or empty");
        }

        // Store the sessionId in sessionStorage
        sessionStorage.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // Validate sessionId to ensure it's a valid session
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("SessionId cannot be null or empty");
       
        // Retrieve the userId from sessionStorage
        return sessionStorage.get(sessionId);
    }

    public void endSession(String sessionId) {
        // Validate sessionId to ensure it's a valid session
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("SessionId cannot be null or empty");
        }

        // Remove the sessionId from sessionStorage
        sessionStorage.remove(sessionId);
    }
}