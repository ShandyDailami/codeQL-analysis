import java.util.HashMap;

public class java_32777_SessionManager_A08 {
    // A map to hold the sessions.
    private static HashMap<String, String> sessionMap;

    // Initializing the session map.
    static {
        sessionMap = new HashMap<>();
    }

    // A method to create a new session.
    public static String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // A method to get the username from a session.
    public static String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // A method to delete a session.
    public static void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}