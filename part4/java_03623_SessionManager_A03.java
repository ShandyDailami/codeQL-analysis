public class java_03623_SessionManager_A03 {
    private static int sessionCount = 0;

    public static void startSession() {
        sessionCount++;
        System.out.println("Started session: " + sessionCount);
    }

    public static void endSession() {
        sessionCount--;
        if (sessionCount < 0) {
            sessionCount = 0;
        }
        System.out.println("Ended session: " + sessionCount);
    }

    public static void main(String[] args) {
        // No injection, as we only use standard Java libraries
        startSession();
        endSession();
    }
}