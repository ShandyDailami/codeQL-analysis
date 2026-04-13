import java.util.HashSet;
import java.util.Set;

public class java_09431_SessionManager_A07 {
    private Set<String> activeSessions;

    public java_09431_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public synchronized void startSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            throw new IllegalStateException("Session already started with ID: " + sessionId);
        }
        activeSessions.add(sessionId);
        System.out.println("Started session: " + sessionId);
    }

    public synchronized void endSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            throw new IllegalStateException("No session found with ID: " + sessionId);
        }
        activeSessions.remove(sessionId);
        System.out.println("Ended session: " + sessionId);
    }

    public synchronized Set<String> getActiveSessions() {
        return new HashSet<>(activeSessions);
    }
}