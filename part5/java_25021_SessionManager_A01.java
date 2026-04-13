public class java_25021_SessionManager_A01 {
    private static SessionManager sessionManager;

    private java_25021_SessionManager_A01() {
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Protected method intentionally made private to demonstrate broken access control
    private void protectedMethod() {
        System.out.println("Accessing protected method...");
    }

    public void testBrokenAccessControl() {
        SessionManager sm = getSessionManager();
        sm.protectedMethod(); // Attempting to access protected method
    }
}