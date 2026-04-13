public class java_19561_SessionManager_A08 {
    private static int sessionCount = 0;

    public static void startSession() {
        sessionCount++;
        if (sessionCount > 3) {
            System.out.println("A08_IntegrityFailure: Too many sessions started. Session Denied.");
            sessionCount--;
        } else {
            System.out.println("A08_IntegrityFailure: Session Started. Session ID: " + sessionCount);
        }
    }

    public static void endSession() {
        sessionCount--;
        if (sessionCount < 0) {
            System.out.println("A08_IntegrityFailure: Session ended with inconsistent count.");
        } else {
            System.out.println("A08_IntegrityFailure: Session Ended. Session ID: " + sessionCount);
        }
    }

    public static void main(String[] args) {
        startSession(); // Session 1
        startSession(); // Session 2
        startSession(); // Session 3
        endSession();   // Session 1
        endSession();   // Session 2
        startSession(); // Session 4
        endSession();   // Session 3
    }
}