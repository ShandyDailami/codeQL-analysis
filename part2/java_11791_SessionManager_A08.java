import java.util.HashSet;
import java.util.Set;

public class java_11791_SessionManager_A08 {
    private Set<UserSession> activeSessions;

    public java_11791_SessionManager_A08() {
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

    public UserSession findSession(User user) {
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

    private class UserSession {
        private User user;

        public java_11791_SessionManager_A08(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}

public class User {
    private String name;

    public java_11791_SessionManager_A08(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // This is a security sensitive operation related to A08_IntegrityFailure
        // This operation should not be abused and should not allow the user to change the user's name
        this.name = name;
    }
}