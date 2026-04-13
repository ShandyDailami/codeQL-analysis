import java.util.HashMap;
import java.util.Map;

public class java_35477_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_35477_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, Session session) {
        sessionMap.put(userId, session);
    }

    public Session getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void destroySession(String userId) {
        sessionMap.remove(userId);
    }

    public static class Session {
        private String userId;

        public java_35477_SessionManager_A07(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session for user1
        Session session1 = sessionManager.createSession("user1", new Session("user1"));

        // Get the session for user1
        Session retrievedSession = sessionManager.getSession("user1");

        // Destroy the session for user1
        sessionManager.destroySession("user1");

        // Check if the session has been destroyed
        if (retrievedSession == null) {
            System.out.println("Session has been destroyed");
        } else {
            System.out.println("Session has not been destroyed");
        }
    }
}