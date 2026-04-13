import java.util.HashMap;
import java.util.Map;

public class java_41908_SessionManager_A08 {

    // Store all active sessions
    private static Map<String, String> sessionMap = new HashMap<>();

    // Session key is username
    // Session value is session id

    // Method to create a session
    public static String createSession(String username) {
        String sessionId = Integer.toString(username.hashCode());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate a session
    public static boolean validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return true;
        }
        return false;
    }

    // Method to get the username from a session
    public static String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public static void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // For testing
    public static void main(String[] args) {
        String sessionId = createSession("user1");
        System.out.println("Session created with id: " + sessionId);
        System.out.println("Valid session: " + validateSession(sessionId));
        System.out.println("Username: " + getUsername(sessionId));
        endSession(sessionId);
        System.out.println("Session ended");
    }
}