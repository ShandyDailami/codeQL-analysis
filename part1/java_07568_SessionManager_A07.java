public class java_07568_SessionManager_A07 {
    // Private instance for Singleton
    private static SessionManager sessionManager;

    // Private constructor to prevent instantiation from other classes
    private java_07568_SessionManager_A07() { }

    // Public method to get the Singleton instance
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Simulated method for opening a session
    public void openSession() {
        System.out.println("Session opened!");
    }

    // Simulated method for closing a session
    public void closeSession() {
        System.out.println("Session closed!");
    }
}