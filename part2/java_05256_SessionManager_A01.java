import java.util.HashMap;

public class java_05256_SessionManager_A01 {
    // Create a HashMap to store sessions
    private HashMap<String, Session> sessions;

    // Session class
    class Session {
        private String username;

        Session(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    // Constructor
    public java_05256_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String username) {
        Session session = new Session(username);
        sessions.put(username, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String username) {
        if(sessions.containsKey(username)) {
            return sessions.get(username);
        } else {
            System.out.println("No session found for username: " + username);
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a new session
        Session session = sessionManager.createSession("testUser");

        // Try to access the session
        Session sessionAccess = sessionManager.getSession("testUser");

        // This will print: No session found for username: testUser
        if(sessionAccess != null) {
            System.out.println("Session found for user: " + sessionAccess.getUsername());
        }
    }
}