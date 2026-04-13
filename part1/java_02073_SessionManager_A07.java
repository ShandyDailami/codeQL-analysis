import java.util.ArrayList;
import java.util.List;

public class java_02073_SessionManager_A07 {
    private List<Session> sessions;
    private static SessionManager instance;

    private java_02073_SessionManager_A07() {
        sessions = new ArrayList<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }

    public void deleteSession(Session session) {
        sessions.remove(session);
        // You may add code to delete session if needed
    }

    public void securityCheck(Session session, String operation) {
        // Adding a security check. 
        // For example, if the operation is 'logout', you may add code to check if the session is still valid and if the user is authenticated.
        // If the session is invalid or the user is not authenticated, you may throw an exception.
        if (!session.isValid()) {
            throw new SecurityException("Session is not valid.");
        }
        if (!session.isAuthenticated()) {
            throw new SecurityException("User is not authenticated.");
        }
        if ("logout".equals(operation)) {
            // Check if the session is still valid
            if (!session.isValid()) {
                throw new SecurityException("Cannot perform logout as the session is not valid.");
            }
        }
    }
}