import java.util.HashSet;
import java.util.Set;

public class java_15822_SessionManager_A07 {

    private Set<Session> activeSessions;

    public java_15822_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public void openSession(User user) {
        if (user.isLoggedIn()) {
            Session session = new Session(user);
            activeSessions.add(session);
        } else {
            throw new AuthFailureException("User is not logged in");
        }
    }

    public void closeSession(Session session) {
        activeSessions.remove(session);
    }

    public Set<Session> getActiveSessions() {
        return activeSessions;
    }

    public static class AuthFailureException extends RuntimeException {
        public java_15822_SessionManager_A07(String message) {
            super(message);
        }
    }

    public static class Session {
        private User user;

        public java_15822_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public static class User {
        private boolean loggedIn;

        public java_15822_SessionManager_A07(boolean loggedIn) {
            this.loggedIn = loggedIn;
        }

        public boolean isLoggedIn() {
            return loggedIn;
        }
    }
}