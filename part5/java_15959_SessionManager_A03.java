public class java_15959_SessionManager_A03 {
    private static int sessionCount = 0;
    private static SessionManager instance;

    private java_15959_SessionManager_A03() {
        sessionCount++;
        System.out.println("SessionManager #" + sessionCount);
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        System.out.println("Starting session...");
    }

    public void endSession() {
        sessionCount--;
        System.out.println("Ending session... Session count: " + sessionCount);
    }
}