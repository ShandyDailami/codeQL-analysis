import java.util.ArrayList;
import java.util.List;

public class java_13713_SessionManager_A01 {
    private List<String> sessions;
    private int sessionCount;

    public java_13713_SessionManager_A01() {
        sessions = new ArrayList<>();
        sessionCount = 0;
    }

    public String createSession() {
        String sessionId = Integer.toHexString(sessionCount++);
        sessions.add(sessionId);
        return sessionId;
    }

    public boolean invalidateSession(String sessionId) {
        if (sessions.contains(sessionId)) {
            sessions.remove(sessionId);
            return true;
        } else {
            return false;
        }
    }

    public List<String> getSessions() {
        return sessions;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create some sessions
        String session1 = sessionManager.createSession();
        String session2 = sessionManager.createSession();
        String session3 = sessionManager.createSession();

        // Invalidate a session
        sessionManager.invalidateSession(session2);

        // Print all sessions
        System.out.println("All sessions: " + sessionManager.getSessions());

        // Invalidate another session
        sessionManager.invalidateSession("Invalid session");

        // Print all sessions again to show that the invalid session was not there
        System.out.println("All sessions after invalidating some sessions: " + sessionManager.getSessions());
    }
}