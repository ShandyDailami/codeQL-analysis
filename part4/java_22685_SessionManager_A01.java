import java.util.*;

public class java_22685_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_22685_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, username);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;
        private String username;

        public java_22685_SessionManager_A01(String sessionId, String username) {
            this.sessionId = sessionId;
            this.username = username;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            // Implementing security sensitive operation related to A01_BrokenAccessControl
            // For example, checking if the username is in a known list of bad users and if so, notifying the user.
            if (Arrays.asList("BAD_USER1", "BAD_USER2").contains(username)) {
                System.out.println("Security alert: detected a potentially harmful username in the system: " + username);
            }

            this.username = username;
        }
    }
}