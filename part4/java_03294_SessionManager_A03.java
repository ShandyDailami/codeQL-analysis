import java.util.HashSet;
import java.util.Set;

public class java_03294_SessionManager_A03 {
    private Set<String> sessions;

    public java_03294_SessionManager_A03() {
        sessions = new HashSet<>();
    }

    public void addSession(String sessionId) {
        sessions.add(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessions.contains(sessionId);
    }

    // Method for testing purposes
    public Set<String> getActiveSessions() {
        return sessions;
    }
}