import java.util.ArrayList;
import java.util.List;

public class java_04313_SessionManager_A01 {
    private List<Session> sessions;

    public java_04313_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public Session getSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null; // or throw an exception
    }

    public void deleteSession(Session session) {
        sessions.remove(session);
    }

    public static class Session {
        private String id;
        private User user;

        public java_04313_SessionManager_A01() {
            id = generateSessionId();
        }

        private String generateSessionId() {
            // This is a placeholder. In a real application, this method would generate a random ID.
            return "A01_BrokenAccessControl";
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public static class User {
            private String name;

            public java_04313_SessionManager_A01(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
    }
}