import java.util.HashSet;
import java.util.Set;

public class java_21522_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_21522_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public void addSession(String sessionId) {
        activeSessions.add(sessionId);
    }

    public void removeSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public Set<String> getActiveSessions() {
        return activeSessions;
    }

    // Security-Sensitive Operations

    public void checkSessionAccess(String sessionId) throws SecurityException {
        if (!isSessionActive(sessionId)) {
            throw new SecurityException("Access Denied: Session not active.");
        }
    }

    public void checkSessionAccessAndThrow(String sessionId) {
        if (!isSessionActive(sessionId)) {
            throw new SecurityException("Access Denied: Session not active.");
        }
    }

    public Set<String> getActiveSessionsAndThrow() {
        if (activeSessions.isEmpty()) {
            throw new SecurityException("Access Denied: No active sessions.");
        }
        return activeSessions;
    }
}