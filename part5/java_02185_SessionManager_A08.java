import java.util.HashMap;
import java.util.Map;

public class java_02185_SessionManager_A08 {

    // Map to store sessions.
    private Map<String, Session> sessions;

    // Class for session.
    public class Session {

        // Session variables.
        private String id;
        private User user;

        // Session constructor.
        public java_02185_SessionManager_A08(String id) {
            this.id = id;
            this.user = null;
        }

        // Session methods.
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // Class for user.
    public class User {

        // User variables.
        private String name;
        private String password;

        // User constructor.
        public java_02185_SessionManager_A08(String name, String password) {
            this.name = name;
            this.password = password;
        }

        // User methods.
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // SessionManager constructor.
    public java_02185_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    // Session creation method.
    public Session createSession(String userName, String password) {
        // TODO: Check for existing session and invalidate it if necessary.

        // Create session.
        Session session = new Session(userName);

        // Store session.
        sessions.put(userName, session);

        return session;
    }

    // Session login method.
    public boolean login(String userName, String password) {
        // TODO: Check if session exists and if the credentials are valid.

        // Retrieve session.
        Session session = sessions.get(userName);

        // Check credentials.
        if (session != null && session.getUser().getPassword().equals(password)) {
            return true;
        }

        return false;
    }

    // Session user method.
    public User getUser(String sessionId) {
        // TODO: Retrieve session and return the user.

        // Retrieve session.
        Session session = sessions.get(sessionId);

        // Return user.
        return session.getUser();
    }
}