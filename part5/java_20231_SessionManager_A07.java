public class java_20231_SessionManager_A07 {
    private static SessionManager instance;
    private static int sessionCount = 0;

    // Private constructor to restrict instantiation of the class
    private java_20231_SessionManager_A07() {}

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        sessionCount++;
        System.out.println("Starting session " + sessionCount + ".");
    }

    public void endSession() {
        if (sessionCount > 0) {
            sessionCount--;
            System.out.println("Ending session " + sessionCount + ".");
        } else {
            instance = null;
            System.out.println("Ending all sessions.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = SessionManager.getInstance();

        manager.startSession();
        // Some code...
        manager.endSession();
    }
}