public class java_05943_SessionManager_A01 {
    // Instance of the SessionManager
    private static SessionManager instance;

    // Private constructor to prevent instantiation from other classes
    private java_05943_SessionManager_A01() {}

    // Public method to get the instance of the SessionManager
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Private variable to store the session
    private Session session;

    // Public method to start a session
    public void startSession() {
        // Here you can use a library or framework to start a session,
        // for example, using JDBC
        session = ...;
    }

    // Public method to end the session
    public void endSession() {
        // Here you can use a library or framework to end the session,
        // for example, using JDBC
        session.close();
        instance = null;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Get the session manager
        SessionManager sessionManager = SessionManager.getInstance();

        // Start a session
        sessionManager.startSession();

        // End the session
        sessionManager.endSession();
    }
}