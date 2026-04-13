import java.util.HashMap;
import java.util.Map;

public class java_29460_SessionManager_A08 {
    // Create a private static HashMap to store user sessions
    private static Map<String, String> sessionMap = new HashMap<>();

    // Method to create a session for a user
    public static String createSession(String userId) {
        // Generate a session token
        String sessionToken = generateSessionToken();

        // Store the userId and session token in the sessionMap
        sessionMap.put(sessionToken, userId);

        return sessionToken;
    }

    // Method to validate a session
    public static String validateSession(String sessionToken) {
        // Validate the session token
        if (sessionMap.containsKey(sessionToken)) {
            return sessionMap.get(sessionToken);
        } else {
            return null;
        }
    }

    // Method to destroy a session
    public static void destroySession(String sessionToken) {
        // Remove the session from the sessionMap
        sessionMap.remove(sessionToken);
    }

    // Method to generate a session token
    private static String generateSessionToken() {
        // Implement your session token generation logic here
        // For example, you can use UUID
        return UUID.randomUUID().toString();
    }
}