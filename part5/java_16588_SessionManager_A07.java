import java.util.HashSet;
import java.util.Set;

public class java_16588_SessionManager_A07 {
    private Set<String> activeSessions;

    public java_16588_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public void startSession(String sessionId) {
        activeSessions.add(sessionId);
    }

    public void endSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public void checkAuthFailure(String sessionId) {
        if (!isSessionActive(sessionId)) {
            throw new AuthFailureException("Session is not active");
        }

        // Sensitive operation here, like database access, etc.
        // This is a security-sensitive operation related to A07_AuthFailure

        // For example, if the operation was to access a user's information,
        // a database call to get the user's info might be made here.
        // This operation should not be performed if the session is not active.
    }
}