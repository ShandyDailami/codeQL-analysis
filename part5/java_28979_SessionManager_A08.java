import java.util.HashMap;
import java.util.Map;

public class java_28979_SessionManager_A08 {
    // Using a Map to store sessions. Key is user ID, value is session.
    private Map<String, Session> sessions;

    public java_28979_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Create a new session for a user.
    public Session createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Get a session for a user.
    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    // Session class.
    public class Session {
        private String userId;

        public java_28979_SessionManager_A08(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        // Simulating a security-sensitive operation.
        public void secureOperation() {
            // Here you can put your code for security-sensitive operations.
            System.out.println("Performing security-sensitive operation for user: " + userId);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session for user A.
        Session sessionA = sessionManager.createSession("A");
        sessionA.secureOperation();

        // Get a session for user B.
        Session sessionB = sessionManager.getSession("B");
        if (sessionB != null) {
            sessionB.secureOperation();
        }
    }
}