import java.util.HashMap;
import java.util.Map;

public class java_39622_SessionManager_A07 {

    // A Map where key is username and value is the session object
    private Map<String, Session> sessionMap;

    public java_39622_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new RuntimeException("Session already exists for the user: " + username);
        }

        Session session = new Session();
        session.setUsername(username);
        sessionMap.put(username, session);

        return session;
    }

    // Method to get session for a given username
    public Session getSession(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new RuntimeException("No session exists for the user: " + username);
        }

        return sessionMap.get(username);
    }

    // Session class
    public class Session {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    // Testing
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a new session for user "alice"
        Session aliceSession = sessionManager.createSession("alice");
        System.out.println("Alice's session ID: " + aliceSession.getUsername());

        // Trying to get the session for "bob"
        try {
            Session bobSession = sessionManager.getSession("bob");
            System.out.println("Bob's session ID: " + bobSession.getUsername());
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}