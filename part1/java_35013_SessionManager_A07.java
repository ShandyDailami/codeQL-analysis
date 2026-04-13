import java.util.HashMap;
import java.util.Map;

public class java_35013_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_35013_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addSession("session1", "user1");
        sessionManager.addSession("session2", "user2");

        System.out.println(sessionManager.getUserId("session1")); // Outputs: user1
        System.out.println(sessionManager.getUserId("session2")); // Outputs: user2

        sessionManager.removeSession("session1");

        System.out.println(sessionManager.getUserId("session1")); // Outputs: null
    }
}