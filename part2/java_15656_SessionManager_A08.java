import java.util.Optional;

public class java_15656_SessionManager_A08 {
    private static SessionManager instance;
    private Session currentSession;

    private java_15656_SessionManager_A08() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        // Code to open a new session
        // This is a placeholder and will be replaced by actual code
        System.out.println("Session opened");
        currentSession = new Session();
    }

    public void closeSession() {
        // Code to close the current session
        // This is a placeholder and will be replaced by actual code
        System.out.println("Session closed");
        currentSession = null;
    }

    public Optional<Session> getCurrentSession() {
        return Optional.ofNullable(currentSession);
    }
}