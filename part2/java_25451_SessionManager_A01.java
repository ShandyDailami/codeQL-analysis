import java.util.HashMap;
import java.util.Map;

public class java_25451_SessionManager_A01 {

    // Create a map for storing sessions. This is not a real database.
    private static Map<String, Session> sessions = new HashMap<>();

    // Session class
    private static class Session {
        private String user;

        public java_25451_SessionManager_A01(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }

    // Create a session
    public static void createSession(String user) {
        if (sessions.containsKey(user)) {
            // Remove the session if it already exists
            sessions.remove(user);
        }
        sessions.put(user, new Session(user));
    }

    // Get the user of a session
    public static String getUser(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            // Return null if the session does not exist
            return null;
        }
        return session.getUser();
    }

    // Remove a session
    public static void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}