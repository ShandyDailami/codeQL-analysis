import java.util.HashSet;
import java.util.Set;

public class java_39334_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_39334_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public synchronized void openSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
        } else {
            throw new RuntimeException("Session already opened: " + sessionId);
        }
    }

    public synchronized void closeSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
        } else {
            throw new RuntimeException("No such session to close: " + sessionId);
        }
    }

    public synchronized void checkSessionIntegrity() {
        if (activeSessions.isEmpty()) {
            throw new RuntimeException("No active session found.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.openSession("session1");
        manager.openSession("session2");
        manager.openSession("session3");

        manager.checkSessionIntegrity(); // No Exception

        manager.closeSession("session1");
        manager.closeSession("session3");

        manager.checkSessionIntegrity(); // Exception

        manager.openSession("session3"); // Exception
    }
}