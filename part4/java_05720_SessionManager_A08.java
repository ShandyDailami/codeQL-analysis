import java.util.HashMap;

public class java_05720_SessionManager_A08 {

    // Create a private HashMap to store session objects
    private HashMap<String, Session> sessionMap = new HashMap<>();

    // Session class
    public class Session {
        private String id;
        private User user;

        public java_05720_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    // User class
    public class User {
        private String name;

        public java_05720_SessionManager_A08(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Method to create a new session
    public Session createSession(String id) {
        Session session = new Session(id);
        sessionMap.put(id, session);
        return session;
    }

    // Method to retrieve a session
    public Session getSession(String id) {
        return sessionMap.get(id);
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a user and a session
        User user = sessionManager.new User("Alice");
        Session session = sessionManager.createSession("session1");
        session.setUser(user);

        // Retrieve the session
        Session retrievedSession = sessionManager.getSession("session1");

        // Check if the session and the user are equal
        if (retrievedSession == session && retrievedSession.getUser().getName().equals("Alice")) {
            System.out.println("Session retrieval test passed!");
        } else {
            System.out.println("Session retrieval test failed!");
        }
    }
}