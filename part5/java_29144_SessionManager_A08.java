import java.util.HashMap;
import java.util.Map;

public class java_29144_SessionManager_A08 {

    // In-memory storage for sessions
    private static Map<String, Session> sessionMap = new HashMap<>();

    // Exception to be thrown when integrity fails
    private static class A08_IntegrityFailure extends RuntimeException {
        public java_29144_SessionManager_A08(String message) {
            super(message);
        }
    }

    // Session class
    public static class Session {
        private String id;

        public java_29144_SessionManager_A08(String id) {
            if (id == null || id.isEmpty()) {
                throw new A08_IntegrityFailure("Session ID can't be null or empty");
            }
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    // Method to create a session
    public static Session createSession(String id) {
        Session session = new Session(id);
        sessionMap.put(id, session);
        return session;
    }

    // Method to retrieve a session
    public static Session getSession(String id) {
        if (!sessionMap.containsKey(id)) {
            throw new A08_IntegrityFailure("Session ID not found");
        }
        return sessionMap.get(id);
    }

    public static void main(String[] args) {
        Session session1 = createSession("session1");
        Session session2 = createSession("session2");

        // Assuming we want to retrieve a non-existent session
        try {
            Session session3 = getSession("non-existent-session");
            System.out.println("Session retrieved successfully");
        } catch (A08_IntegrityFailure e) {
            System.out.println("Error retrieving session: " + e.getMessage());
        }
    }
}