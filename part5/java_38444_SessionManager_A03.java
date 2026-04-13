import java.util.HashMap;
import java.util.Map;

public class java_38444_SessionManager_A03 {

    // Step 1: Declare a static Map to store sessions.
    private static Map<String, Session> sessions = new HashMap<>();

    // Step 2: The SessionManager class should have a method to create a session.
    public static Session createSession(String sessionId) {
        // Step 3: Check if the sessionId is already in use.
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists for the given sessionId: " + sessionId);
        }

        // Step 4: Create a new Session object and store it in the map.
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Step 5: The SessionManager class should have a method to get a session.
    public static Session getSession(String sessionId) {
        // Step 6: Check if the sessionId is in the map.
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session exists for the given sessionId: " + sessionId);
        }

        // Step 7: Return the session from the map.
        return sessions.get(sessionId);
    }

    // Step 8: The SessionManager class should have a method to remove a session.
    public static void destroySession(String sessionId) {
        // Step 9: Remove the session from the map.
        sessions.remove(sessionId);
    }

    // Session class
    public static class Session {
        private String id;

        public java_38444_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}