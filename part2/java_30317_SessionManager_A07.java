import java.util.HashSet;
import java.util.Set;

public class java_30317_SessionManager_A07 {
    private static Set<String> activeSessions;

    public java_30317_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        activeSessions.add(sessionId);
        return sessionId;
    }

    public void endSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for actual session id generation,
        // it could be based on UUID, current time, etc.
        return String.valueOf(System.nanoTime());
    }

    public boolean isActiveSession(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");

        sessionManager.endSession(session1);

        System.out.println("Is session1 active? " + sessionManager.isActiveSession(session1));
        System.out.println("Is session2 active? " + sessionManager.isActiveSession(session2));
    }
}