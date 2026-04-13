public class java_31992_SessionManager_A08 {
    private static int sessionCount = 0;

    public static void main(String[] args) {
        SessionManager sm1 = new SessionManager();
        SessionManager sm2 = new SessionManager();
        sm1.startSession();
        sm2.startSession();
        sm1.endSession();
        sm2.endSession();
    }

    public void startSession() {
        if (sessionCount == 0) {
            System.out.println("Starting session...");
        }
        sessionCount++;
        System.out.println("Session " + sessionCount + " started.");
    }

    public void endSession() {
        if (sessionCount > 0) {
            sessionCount--;
            System.out.println("Session " + sessionCount + " ended.");
        } else {
            System.out.println("No active sessions.");
        }
    }
}