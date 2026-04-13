public class java_25378_SessionManager_A01 {
    private static int sessionCount = 0;

    public java_25378_SessionManager_A01() {
        sessionCount++;
        System.out.println("Created session #" + sessionCount);
    }

    public void startSession() {
        System.out.println("Started session #" + sessionCount);
    }

    public void endSession() {
        sessionCount--;
        if (sessionCount < 0) {
            System.out.println("Error: More closing sessions than opening.");
        } else {
            System.out.println("Ended session #" + sessionCount);
        }
    }
}