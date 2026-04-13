public class java_38955_SessionManager_A08 {

    private static int sessionCount = 0;

    public static void startSession() {
        sessionCount++;
        System.out.println("Started session " + sessionCount + ".");
    }

    public static void endSession(boolean isSuccessful) {
        if (isSuccessful) {
            System.out.println("Ended session successfully.");
        } else {
            handleFailure();
        }
        sessionCount--;
        System.out.println("Ended session " + sessionCount + ".");
    }

    private static void handleFailure() {
        System.out.println("Session integrity failure. Starting new session.");
        startSession();
    }

    // Main method for testing
    public static void main(String[] args) {
        try {
            SessionManager.startSession();
            SessionManager.endSession(true);
            SessionManager.endSession(false);
            SessionManager.endSession(true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}