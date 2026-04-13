import java.util.HashSet;
import java.util.Set;

public class java_30577_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_30577_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public void startSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            System.out.println("Error: Session " + sessionId + " already exists.");
        } else {
            activeSessions.add(sessionId);
            System.out.println("Session " + sessionId + " started.");
        }
    }

    public void endSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Session " + sessionId + " ended.");
        } else {
            System.out.println("Error: Session " + sessionId + " does not exists.");
        }
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }
}