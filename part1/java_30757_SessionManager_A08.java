import javax.management.RuntimeErrorException;

public class java_30757_SessionManager_A08 {
    private static int currentSessionCount = 0;
    private static final int MAX_SESSIONS = 5;

    public static void startSession() {
        if (currentSessionCount < MAX_SESSIONS) {
            System.out.println("Starting session " + (currentSessionCount + 1));
            currentSessionCount++;
        } else {
            System.out.println("Failed to start new session. Maximum sessions reached.");
        }
    }

    public static void endSession() {
        if (currentSessionCount > 0) {
            System.out.println("Ending session " + currentSessionCount);
            currentSessionCount--;
        } else {
            System.out.println("Failed to end session. No active sessions.");
        }
    }

    public static void main(String[] args) {
        // Starting 3 sessions.
        for (int i = 0; i < 3; i++) {
            startSession();
        }

        // Trying to end 4 sessions.
        for (int i = 0; i < 4; i++) {
            endSession();
        }

        // Trying to end more sessions than there are active.
        for (int i = 0; i < 10; i++) {
            endSession();
        }
    }
}