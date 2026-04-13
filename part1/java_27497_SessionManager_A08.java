import java.util.HashMap;
import java.util.Map;

public class java_27497_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_27497_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        // Check if session is already started
        if (sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session already started");
        }

        // Check if user is authorized to start a session
        // In a real-world scenario, you would ideally use a user service to check permissions
        if (!isAuthorizedUser(userId)) {
            throw new SecurityException("User is not authorized to start a session");
        }

        // Start the session
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        // Check if session is already ended
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session not started");
        }

        // End the session and remove user from session map
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);

        // Check if user is authorized to end a session
        if (!isAuthorizedUser(userId)) {
            throw new SecurityException("User is not authorized to end a session");
        }
    }

    private boolean isAuthorizedUser(String userId) {
        // Replace with a call to a user service to check user permissions
        // For the purpose of this example, we return true or false for simplicity
        return userId != null && !userId.isEmpty();
    }
}