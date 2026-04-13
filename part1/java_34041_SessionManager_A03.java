import java.util.ArrayList;
import java.util.List;

public class java_34041_SessionManager_A03 {
    private static List<Session> sessions = new ArrayList<>();

    // Singleton instance
    private static SessionManager instance = null;

    // Private constructor to restrict instantiation from other classes
    private java_34041_SessionManager_A03() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // A03_Injection
    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public void closeAllSessions() {
        sessions.forEach(Session::close);
        sessions.clear();
    }
}

public class Session {
    private boolean isOpen = false;

    // A03_Injection
    public java_34041_SessionManager_A03(String connectionString) {
        // Connect to the database using the connection string
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
}