import java.util.*;

public class java_40295_SessionManager_A01 {
    private Map<String, UserSession> sessions;

    public java_40295_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(User user) {
        UserSession session = new UserSession(user);
        sessions.put(session.getId(), session);
    }

    public void endSession(String sessionId) {
        UserSession session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    public UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static class UserSession {
        private User user;
        private Date startTime;

        public java_40295_SessionManager_A01(User user) {
            this.user = user;
            startTime = new Date();
        }

        public String getId() {
            return user.getUsername() + "-" + startTime.getTime();
        }

        public User getUser() {
            return user;
        }

        public Date getStartTime() {
            return startTime;
        }
    }

    public static class User {
        private String username;
        private String password;

        public java_40295_SessionManager_A01(String username, String password) {
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