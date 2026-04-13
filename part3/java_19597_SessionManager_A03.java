import java.util.HashSet;
import java.util.Set;

public class java_19597_SessionManager_A03 {
    private Set<String> activeSessions;

    public java_19597_SessionManager_A03() {
        activeSessions = new HashSet<>();
    }

    public String createSession(String userId) {
        if (activeSessions.contains(userId)) {
            throw new IllegalStateException("User already has an active session.");
        }

        String sessionId = userId + System.currentTimeMillis();
        activeSessions.add(sessionId);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            throw new IllegalStateException("No active session with the provided id exists.");
        }

        activeSessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session: " + sessionId);

        sessionManager.destroySession(sessionId);
        System.out.println("Destroyed session: " + sessionId);
    }
}