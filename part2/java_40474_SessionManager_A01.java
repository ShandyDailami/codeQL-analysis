import java.util.HashSet;
import java.util.Set;

public class java_40474_SessionManager_A01 {
    // Custom SessionFactory for session management
    private SessionFactory sessionFactory;

    // Set of sessions for concurrency control
    private Set<Session> sessions = new HashSet<>();

    // Constructor
    public java_40474_SessionManager_A01(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method for creating a session
    public Session createSession() {
        // Create a session
        Session session = sessionFactory.openSession();
        sessions.add(session);
        return session;
    }

    // Method for destroying a session
    public void destroySession(Session session) {
        // Remove the session from the set
        sessions.remove(session);
        session.close();
    }

    // Method for destroying all sessions
    public void destroyAllSessions() {
        // Iterate over all sessions and close them
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    // Method for accessing a session
    public Session getSession(Long id) {
        // Find the session in the set
        for (Session session : sessions) {
            if (session.getId().equals(id)) {
                return session;
            }
        }
        return null;
    }

    // Security-sensitive operation: Accessing session by id
    public void accessSessionById(Long id) {
        Session session = getSession(id);
        if (session == null) {
            System.out.println("Error: Access denied for session with id " + id);
        }
    }

    // Security-sensitive operation: Accessing session by id after destroying session
    public void accessSessionAfterDestroy(Long id) {
        Session session = getSession(id);
        if (session != null) {
            System.out.println("Error: Access denied for session with id " + id);
        }
    }
}