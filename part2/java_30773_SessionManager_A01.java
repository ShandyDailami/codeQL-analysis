import java.util.ArrayList;
import java.util.List;

public class java_30773_SessionManager_A01 {
    // List to store sessions
    private List<Session> sessions;

    public java_30773_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    // Method to create a new session
    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    // Method to check if a session is valid
    public boolean isValidSession(Session session) {
        // Assume session is valid if it is in the list of sessions
        return sessions.contains(session);
    }

    // Session class
    public class Session {
        // Some fields and methods...
    }
}