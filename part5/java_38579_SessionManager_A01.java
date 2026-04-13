import java.util.HashMap;
import java.util.Map;

public class java_38579_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_38579_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void deleteSession(String userId) {
        sessions.remove(userId);
    }
}

public class BrokenAccessControl {
    private SessionManager sessionManager;

    public java_38579_SessionManager_A01() {
        sessionManager = new SessionManager();
    }

    public void accessSession(String userId, String sessionId) {
        sessionManager.createSession(userId, sessionId);

        // Assume a secure operation to get the session
        String fetchedSession = sessionManager.getSession(userId);

        // Broken Access Control: trying to access the session without the correct permission
        if (fetchedSession.equals(sessionId)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}