import java.util.HashSet;
import java.util.Set;

public class java_05544_SessionManager_A08 {
    private static Set<String> activeSessions = new HashSet<>();

    public static void startSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            System.out.println("Session already active with id: " + sessionId);
        } else {
            activeSessions.add(sessionId);
            System.out.println("Started session with id: " + sessionId);
        }
    }

    public static void endSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Ended session with id: " + sessionId);
        } else {
            System.out.println("No active session with id: " + sessionId);
        }
    }

    public static void checkSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            System.out.println("Session is active with id: " + sessionId);
        } else {
            System.out.println("No active session with id: " + sessionId);
        }
    }

    public static void main(String[] args) {
        startSession("Session1");
        startSession("Session2");
        endSession("Session1");
        startSession("Session2");
        checkSession("Session2");
    }
}