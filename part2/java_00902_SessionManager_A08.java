import java.util.HashSet;
import java.util.Set;

public class java_00902_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_00902_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public void openSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
            System.out.println("Open session: " + sessionId);
        } else {
            System.out.println("Session already open: " + sessionId);
        }
    }

    public void closeSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Close session: " + sessionId);
        } else {
            System.out.println("No such session found to close: " + sessionId);
        }
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }
}