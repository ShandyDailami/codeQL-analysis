import java.util.HashSet;
import java.util.Set;

public class java_39298_SessionManager_A07 {
    private Set<String> activeSessions;

    public java_39298_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public synchronized void openSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
            System.out.println("Session " + sessionId + " opened. Active sessions: " + activeSessions.size());
        } else {
            System.out.println("Session " + sessionId + " is already open. Active sessions: " + activeSessions.size());
        }
    }

    public synchronized void closeSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Session " + sessionId + " closed. Active sessions: " + activeSessions.size());
        } else {
            System.out.println("Session " + sessionId + " is not open. Active sessions: " + activeSessions.size());
        }
    }

    public static void main(String[] args) {
        UniqueVanillaJavaSessionManager sessionManager = new UniqueVanillaJavaSessionManager();

        // Opening sessions
        sessionManager.openSession("Session1");
        sessionManager.openSession("Session2");
        sessionManager.openSession("Session1"); // Should print: Session Session1 is already open. Active sessions: 2

        // Closing sessions
        sessionManager.closeSession("Session2");
        sessionManager.closeSession("Session3"); // Should print: Session Session3 is not open. Active sessions: 1
    }
}