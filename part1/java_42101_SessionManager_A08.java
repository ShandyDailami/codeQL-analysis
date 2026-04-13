import java.util.HashSet;

public class java_42101_SessionManager_A08 {

    // A HashSet will automatically prevent duplicate sessions
    private HashSet<String> activeSessions;

    public java_42101_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    // This method adds a session to the manager
    public void addSession(String sessionId) {
        activeSessions.add(sessionId);
    }

    // This method removes a session from the manager
    public void removeSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    // This method checks if a session is active
    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    // This method is called to check if integrity is violated
    public boolean isIntegrityViolated() {
        // If the active sessions list is empty, then no integrity violation has occurred
        if (activeSessions.isEmpty()) {
            return false;
        }
        // If there's only one session, then it's the only active session, which violates integrity
        if (activeSessions.size() == 1) {
            return true;
        }
        // If there's more than one active session, then integrity is violated
        return true;
    }
}