import java.util.HashSet;
import java.util.Set;

public class java_30134_SessionManager_A07 {
    private Set<Session> activeSessions;

    public java_30134_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public Session createSession(User user) {
        Session newSession = new Session(user);
        activeSessions.add(newSession);
        return newSession;
    }

    public void deleteSession(Session session) {
        activeSessions.remove(session);
    }

    public void checkAuthFailure(Session session) {
        if (session.getUser().hasFailedAuthAttempts()) {
            System.out.println("Authentication failure detected for user: " + session.getUser().getName());
            // Handle authentication failure
            // You might want to log the user out or trigger an authentication failure event
            // For the sake of simplicity, we'll just remove the session from the manager
            deleteSession(session);
        }
    }

    public static class Session {
        private User user;

        public java_30134_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public static class User {
        private String name;
        private int failedAuthAttempts;

        public java_30134_SessionManager_A07(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void failedAuthAttempt() {
            failedAuthAttempts++;
        }

        public boolean hasFailedAuthAttempts() {
            return failedAuthAttempts > 0;
        }
    }
}