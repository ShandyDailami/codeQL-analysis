import java.util.HashMap;
import java.util.Map;

public class java_09173_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_09173_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Check if a session with the given userId already exists
        if (sessionMap.containsKey(userId)) {
            System.out.println("Error: Session already exists for userId: " + userId);
            return;
        }

        // Create a new session and store it in the map
        String sessionId = createSession(userId);
        sessionMap.put(userId, sessionId);
    }

    public void endSession(String userId) {
        // Check if a session with the given userId exists
        if (!sessionMap.containsKey(userId)) {
            System.out.println("Error: No session found for userId: " + userId);
            return;
        }

        // Remove the session from the map
        String sessionId = sessionMap.get(userId);
        sessionMap.remove(userId);
    }

    private String createSession(String userId) {
        // This is a placeholder method, you should implement the actual session creation logic
        return userId + "-session";
    }
}