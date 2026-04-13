import java.util.HashMap;
import java.util.Map;

public class java_35900_SessionManager_A01 {
    // Create a private static HashMap to hold the sessions
    private static Map<String, String> sessionMap = new HashMap<>();

    // Method to handle login
    public static String login(String username, String password) {
        // Here you would typically connect to your database and verify the username and password
        // For the purposes of this example, we're just checking if the username and password match a known one
        if ("admin".equals(username) && "password".equals(password)) {
            // If the login is successful, create a session for the user and return a session ID
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            // If the login is not successful, return null
            return null;
        }
    }

    // Method to handle logout
    public static void logout(String sessionId) {
        // Here we're simply removing the session from the map
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is valid
    public static boolean isValidSession(String sessionId) {
        // Here we're just checking if the session exists in the map
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the username from a session
    public static String getUsernameFromSession(String sessionId) {
        // Here we're just getting the username from the map
        return sessionMap.get(sessionId);
    }

    // Helper method to generate a session ID
    private static String generateSessionId() {
        // Here we're generating a random session ID, this would typically be a UUID in a real application
        return String.valueOf(System.currentTimeMillis());
    }
}