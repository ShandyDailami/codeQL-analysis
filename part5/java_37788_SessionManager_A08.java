public class java_37788_SessionManager_A08 {
    private static int sessionCounter = 0;

    public static void main(String[] args) {
        SessionManager sm1 = new SessionManager();
        sm1.startSession();
        sm1.endSession();

        SessionManager sm2 = new SessionManager();
        sm2.startSession();
        sm2.endSession();
    }

    private int sessionId;

    public java_37788_SessionManager_A08() {
        sessionCounter++;
        sessionId = sessionCounter;
    }

    public void startSession() {
        System.out.println("Session " + sessionId + " started");
        // Security-sensitive operations related to integrity failure.
        // For instance, we're storing a value in a variable.
        String sensitiveInfo = "IntegrityFailure";
        System.out.println("Storing sensitive info: " + sensitiveInfo);
    }

    public void endSession() {
        System.out.println("Session " + sessionId + " ended");
        // Security-sensitive operations related to integrity failure.
        // For instance, we're removing a value from a variable.
        String sensitiveInfo = "IntegrityFailure";
        System.out.println("Removing sensitive info: " + sensitiveInfo);
    }
}