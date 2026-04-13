import java.util.HashSet;
import java.util.Set;

public class java_13870_SessionManager_A08 {

    private Set<UserSession> activeSessions;

    public java_13870_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public void startSession(User user) {
        UserSession session = new UserSession(user);
        activeSessions.add(session);
    }

    public void endSession(User user) {
        UserSession session = findSession(user);
        if (session != null) {
            activeSessions.remove(session);
        }
    }

    private UserSession findSession(User user) {
        for (UserSession session : activeSessions) {
            if (session.getUser().equals(user)) {
                return session;
            }
        }
        return null;
    }

    public Set<UserSession> getActiveSessions() {
        return activeSessions;
    }

    public class UserSession {
        private User user;

        public java_13870_SessionManager_A08(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public class User {
        private String username;
        private String password;

        public java_13870_SessionManager_A08(String username, String password) {
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

}