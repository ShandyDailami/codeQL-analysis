import java.util.HashSet;
import java.util.Set;

public class java_33105_SessionManager_A07 {
    private static Set<Session> activeSessions = new HashSet<>();

    // Session class
    public static class Session {
        private String sessionId;
        private User user;

        public java_33105_SessionManager_A07(String sessionId, User user) {
            this.sessionId = sessionId;
            this.user = user;
            activeSessions.add(this);
        }

        public String getSessionId() {
            return sessionId;
        }

        public User getUser() {
            return user;
        }

        public void invalidate() {
            activeSessions.remove(this);
        }
    }

    // User class
    public static class User {
        private String username;
        private String password;

        public java_33105_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public static User login(String username, String password) {
            // Implement a login logic here
            // Return the user if login is successful, otherwise return null
            for (User user : activeUsers.values()) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }

        public static void logout(User user) {
            // Implement a logout logic here
            user.invalidate();
        }
    }
}