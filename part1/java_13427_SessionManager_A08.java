import java.util.HashSet;
import java.util.Set;

public class java_13427_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_13427_SessionManager_A08() {
        this.activeSessions = new HashSet<>();
    }

    public synchronized void openSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
            System.out.println("Opened session: " + sessionId);
        } else {
            System.out.println("Session already open: " + sessionId);
        }
    }

    public synchronized void closeSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Closed session: " + sessionId);
        } else {
            System.out.println("No active session found for session id: " + sessionId);
        }
    }

    public synchronized void integrityCheck(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            System.out.println("No active session found for session id: " + sessionId);
        } else {
            System.out.println("Integrity check for session: " + sessionId + " passed");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Open sessions
        sessionManager.openSession("session1");
        sessionManager.openSession("session2");
        sessionManager.openSession("session1");

        // Close sessions
        sessionManager.closeSession("session2");
        sessionManager.closeSession("session1");

        // Check session integrity
        sessionManager.integrityCheck("session1");
        sessionManager.integrityCheck("nonExistentSession");
    }
}