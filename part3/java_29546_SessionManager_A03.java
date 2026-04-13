import java.util.HashMap;
import java.util.Map;

public class java_29546_SessionManager_A03 {

    private static Map<String, Object> sessionMap;

    // Initialize the session map when the class is loaded
    static {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public static void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    // Method to retrieve a session
    public static Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public static void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}