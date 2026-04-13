public class java_07548_SessionManager_A01 {
    // private instance of SessionManager
    private static SessionManager sessionManager;

    // private constructor to prevent instantiation
    private java_07548_SessionManager_A01() {
        // initialize the session if needed (e.g., using a database or other persistent storage)
    }

    // public method to get the instance of SessionManager
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // example method to start a session
    public void startSession() {
        System.out.println("Starting a session.");
    }

    // example method to end a session
    public void endSession() {
        System.out.println("Ending a session.");
    }
}