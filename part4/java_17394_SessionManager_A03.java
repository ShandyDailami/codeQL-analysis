import java.util.HashMap;
import java.util.Map;

public class java_17394_SessionManager_A03 {
    // A session map to store sessions.
    private Map<String, Session> sessions;

    // The SessionManager constructor.
    public java_17394_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // A Session class that contains session data.
    public class Session {
        private String id;
        private String user;

        public java_17394_SessionManager_A03(String id, String user) {
            this.id = id;
            this.user = user;
        }

        // Getters and setters for id and user.
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }

    // Method to create a new session.
    public Session createSession(String id, String user) {
        Session session = new Session(id, user);
        sessions.put(id, session);
        return session;
    }

    // Method to get a session.
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Method to remove a session.
    public void removeSession(String id) {
        sessions.remove(id);
    }

    // Main method for testing.
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("s1", "user1");
        Session s = manager.getSession("s1");
        System.out.println("Session user: " + s.getUser());
        manager.removeSession("s1");
    }
}