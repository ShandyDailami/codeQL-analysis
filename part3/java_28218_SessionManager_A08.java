import java.util.LinkedList;

public class java_28218_SessionManager_A08 {
    // A LinkedList to hold sessions
    private LinkedList<Session> sessions = new LinkedList<>();

    // A session class
    public static class Session {
        private String sessionId;
        private User user;

        public java_28218_SessionManager_A08(String sessionId, User user) {
            this.sessionId = sessionId;
            this.user = user;
        }

        public String getSessionId() {
            return sessionId;
        }

        public User getUser() {
            return user;
        }
    }

    // A user class
    public static class User {
        private String username;
        private String password;

        public java_28218_SessionManager_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    // Method to add a new session
    public void addSession(String sessionId, String username, String password) {
        sessions.add(new Session(sessionId, new User(username, password)));
    }

    // Method to validate a session
    public User validateSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getSessionId().equals(sessionId)) {
                return session.getUser();
            }
        }
        return null;
    }
}