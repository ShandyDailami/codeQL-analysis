import java.util.HashSet;
import java.util.Set;

public class java_39303_SessionManager_A07 {
    private static Set<String> activeSessions = new HashSet<>();

    public static void startSession(String sessionId) {
        activeSessions.add(sessionId);
    }

    public static void endSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public static boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void main(String[] args) {
        try {
            // Starting session 1
            SessionManager.startSession("Session1");

            // Checking if session is active
            if (SessionManager.isSessionActive("Session1")) {
                System.out.println("Session 1 is active.");
            } else {
                System.out.println("Session 1 is not active.");
            }

            // Starting session 2
            SessionManager.startSession("Session2");

            // Checking if sessions are active
            if (SessionManager.isSessionActive("Session1")) {
                System.out.println("Session 1 is active.");
            } else {
                System.out.println("Session 1 is not active.");
            }

            if (SessionManager.isSessionActive("Session2")) {
                System.out.println("Session 2 is active.");
            } else {
                System.out.println("Session 2 is not active.");
            }

            // Ending session 2
            SessionManager.endSession("Session2");

            // Checking if sessions are active
            if (SessionManager.isSessionActive("Session2")) {
                System.out.println("Session 2 is active.");
            } else {
                System.out.println("Session 2 is not active.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}