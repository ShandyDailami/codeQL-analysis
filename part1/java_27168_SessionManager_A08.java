import java.util.HashMap;
import java.util.Map;

public class java_27168_SessionManager_A08 {
    // Use a HashMap for session storage to simulate a real session storage
    private Map<String, String> sessionStorage;

    public java_27168_SessionManager_A08() {
        sessionStorage = new HashMap<>();
    }

    // Create a method to create a session
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionStorage.put(sessionId, userId);
        return sessionId;
    }

    // Create a method to get the userId associated with a session
    public String getUserId(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    // Create a method to delete a session
    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }

    // Create a method to generate a unique session id
    private String generateSessionId() {
        // This is a simplified session id generation. In a real world scenario, 
        // this method should be more complex and secure to prevent session hijacking.
        return String.valueOf(System.nanoTime());
    }
}