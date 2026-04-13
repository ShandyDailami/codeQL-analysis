public class java_06283_SessionManager_A03 {
    private int sessionCount = 0;
    private static SessionManager instance = null;

    // Private constructor to prevent instantiation
    private java_06283_SessionManager_A03() {
        // Nothing to do here, just prevent instantiation
    }

    // Public method to get the instance of the SessionManager
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to start a session
    public void startSession() {
        System.out.println("Starting session " + (sessionCount + 1));
        sessionCount++;
    }

    // Method to end a session
    public void endSession() {
        System.out.println("Ending session " + sessionCount);
        sessionCount--;
    }
}