import java.util.ArrayList;
import java.util.List;

public class java_32931_SessionManager_A08 {
    // List to store sessions.
    private List<Session> sessions = new ArrayList<>();

    // Session class.
    public class Session {
        private boolean isValid;

        public java_32931_SessionManager_A08() {
            this.isValid = true;
        }

        public void close() {
            isValid = false;
        }

        public boolean isValid() {
            return isValid;
        }
    }

    // Method to create a new session.
    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    // Method to close a session.
    public void closeSession(Session session) {
        session.close();
    }

    // Method to check if a session is valid.
    public boolean isValid(Session session) {
        return session.isValid();
    }
}