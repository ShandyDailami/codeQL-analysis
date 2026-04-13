import java.util.*;

public class java_38608_SessionManager_A03 {
    private static Map<String, String> sessionMap = new HashMap<>();

    public static void main(String[] args) {
        // Create sessions
        createSession("session1", "user1");
        createSession("session2", "user2");

        // Print sessions
        System.out.println("Sessions: " + sessionMap.keySet());

        // Access data in sessions
        System.out.println("Session 1 Data: " + getSessionData("session1"));
        System.out.println("Session 2 Data: " + getSessionData("session2"));

        // Update session data
        updateSessionData("session1", "new user");
        System.out.println("Updated Session 1 Data: " + getSessionData("session1"));
    }

    private static void createSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    private static String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private static void updateSessionData(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }
}