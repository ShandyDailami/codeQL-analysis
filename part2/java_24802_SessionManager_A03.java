// Imports
import java.util.HashMap;
import java.util.Map;

public class java_24802_SessionManager_A03 {

    private static Map<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public static String createSession(String userId) {
        // Add session to sessionMap
        sessionMap.put(userId, userId);

        // Return sessionId
        return userId;
    }

    // Method to get session details
    public static String getSession(String sessionId) {
        // Return the session details
        return sessionMap.get(sessionId);
    }

    // Method to remove session
    public static void removeSession(String sessionId) {
        // Remove session from sessionMap
        sessionMap.remove(sessionId);
    }
}