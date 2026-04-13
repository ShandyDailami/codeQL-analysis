import java.util.ArrayList;
import java.util.List;

public class java_32094_SessionManager_A03 {
    private List<String> sessions;

    public java_32094_SessionManager_A03() {
        sessions = new ArrayList<>();
    }

    public void createSession(String sessionId) {
        // Session is created, add the sessionId to the list
        sessions.add(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Session is deleted, remove the sessionId from the list
        sessions.remove(sessionId);
    }

    public void deleteAllSessions() {
        // Delete all sessions
        sessions.clear();
    }

    public boolean hasSession(String sessionId) {
        // Check if the sessionId is in the list
        return sessions.contains(sessionId);
    }

    public List<String> getAllSessions() {
        // Return all session IDs
        return sessions;
    }
}