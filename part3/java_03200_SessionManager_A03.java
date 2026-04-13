import java.util.HashMap;
import java.util.Map;

public class java_03200_SessionManager_A03 {
    // Declare a static HashMap to store the sessions
    private static Map<String, String> sessionMap;

    // Initialize the sessionMap
    static {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public static String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session
    public static String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public static void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public static boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}