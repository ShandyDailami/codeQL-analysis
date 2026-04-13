import java.util.HashSet;
import java.util.Set;

public class java_18891_SessionManager_A03 {
    private Set<String> activeSessions;

    public java_18891_SessionManager_A03() {
        activeSessions = new HashSet<>();
    }

    public void startSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        activeSessions.add(sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        activeSessions.remove(sessionId);
    }

    public Set<String> getActiveSessions() {
        return activeSessions;
    }
}