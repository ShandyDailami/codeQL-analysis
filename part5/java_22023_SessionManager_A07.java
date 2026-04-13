import java.util.ArrayList;
import java.util.List;

public class java_22023_SessionManager_A07 {
    private List<String> activeSessions;

    public java_22023_SessionManager_A07() {
        activeSessions = new ArrayList<>();
    }

    public void openSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            System.out.println("Session already open with id: " + sessionId);
        } else {
            activeSessions.add(sessionId);
            System.out.println("Opened session with id: " + sessionId);
        }
    }

    public void closeSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Closed session with id: " + sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
        }
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Open sessions
        sessionManager.openSession("session1");
        sessionManager.openSession("session2");
        sessionManager.openSession("session1"); // Should print "Session already open with id: session1"

        // Close sessions
        sessionManager.closeSession("session1"); // Should print "Closed session with id: session1"
        sessionManager.closeSession("session3"); // Should print "No session found with id: session3"

        // Check session status
        System.out.println("Is session1 active? " + sessionManager.isSessionActive("session1")); // Should print "true"
        System.out.println("Is session2 active? " + sessionManager.isSessionActive("session2")); // Should print "true"
        System.out.println("Is session3 active? " + sessionManager.isSessionActive("session3")); // Should print "false"
    }
}