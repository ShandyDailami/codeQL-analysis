import java.util.ArrayList;
import java.util.List;

public class java_13553_SessionManager_A08 {
    // Define a list to hold open sessions
    private static List<Session> openSessions = new ArrayList<>();

    // Define a static session creation method
    public static Session createSession() {
        // Create a new session and add it to the list of open sessions
        Session newSession = new Session();
        openSessions.add(newSession);
        return newSession;
    }

    // Define a static session validation method
    public static boolean validateSession(Session session) {
        // Return whether the provided session is in the list of open sessions
        return openSessions.contains(session);
    }

    // Define a static session invalidation method
    public static void invalidateSession(Session session) {
        // Remove the provided session from the list of open sessions
        openSessions.remove(session);
    }

    // Session class for holding session details
    public static class Session {
        private String id;

        // Constructor and getters
        public java_13553_SessionManager_A08() {
            // Generate a new session id
            this.id = java.util.UUID.randomUUID().toString();
        }

        public String getId() {
            return id;
        }
    }
}