import java.util.HashMap;
import java.util.Map;

public class java_22498_SessionManager_A07 {
    private Map<String, User> sessions;

    public java_22498_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session login(String username, String password) {
        // This is a placeholder for real authentication
        if ("admin".equals(username) && "password".equals(password)) {
            User user = new User(username);
            sessions.put(user.getName(), user);
            return new Session(user);
        }
        return null;
    }

    public User getUser(String sessionKey) {
        return sessions.get(sessionKey);
    }

    public static class User {
        private String name;

        public java_22498_SessionManager_A07(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Session {
        private User user;

        public java_22498_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}