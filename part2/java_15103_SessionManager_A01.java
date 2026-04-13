import java.util.HashMap;
import java.util.Map;

public class java_15103_SessionManager_A01 {
    // This is a dummy HashMap to simulate a database.
    // In a real application, you would use a real database like MySQL, Oracle, etc.
    private Map<String, String> userDatabase = new HashMap<>();

    public java_15103_SessionManager_A01() {
        // Add some users to the userDatabase. In a real application, this would be done securely.
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    // Method to authenticate a user.
    public boolean authenticate(String username, String password) {
        return password.equals(userDatabase.get(username));
    }

    // This is a basic session class. In a real application, you would use a full-featured session library.
    public class Session {
        private String user;

        public java_15103_SessionManager_A01(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }

    // Basic session manager.
    public class SessionManager {
        private Map<String, Session> sessions = new HashMap<>();

        // Method to open a session for a user.
        public Session openSession(String username, String password) {
            if (authenticate(username, password)) {
                Session session = new Session(username);
                sessions.put(username, session);
                return session;
            } else {
                throw new SecurityException("Authentication failed");
            }
        }

        // Method to get a session for a user.
        public Session getSession(String username) {
            return sessions.get(username);
        }

        // Method to close a session for a user.
        public void closeSession(String username) {
            sessions.remove(username);
        }
    }
}