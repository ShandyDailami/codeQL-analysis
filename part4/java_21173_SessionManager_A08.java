import java.util.*;

public class java_21173_SessionManager_A08 {

    private static List<String> activeSessions = new ArrayList<>();
    private static int sessionCount = 0;

    // Start session
    public static void startSession() {
        sessionCount++;
        activeSessions.add("Session " + sessionCount);
        System.out.println("Started session: " + activeSessions.get(sessionCount - 1));
    }

    // End session
    public static void endSession(String session) {
        activeSessions.remove(session);
        System.out.println("Ended session: " + session);
    }

    // Get session list
    public static void getSessions() {
        System.out.println("Active sessions: " + activeSessions);
    }

    // Check for integrity failures
    public static void integrityCheck() {
        if (sessionCount == 0) {
            System.out.println("No sessions currently active.");
        } else {
            System.out.println("Integrity check failed. The following sessions are still active: " + activeSessions);
        }
    }

    // Main method
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession();
        sm.startSession();
        sm.startSession();
        sm.integrityCheck();
        sm.endSession(sm.activeSessions.get(0));
        sm.endSession(sm.activeSessions.get(1));
        sm.endSession(sm.activeSessions.get(2));
        sm.integrityCheck();
    }
}