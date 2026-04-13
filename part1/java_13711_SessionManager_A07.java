import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;

public class java_13711_SessionManager_A07 {

    // Store all the active sessions
    private List<Session> activeSessions;

    public java_13711_SessionManager_A07() {
        activeSessions = new ArrayList<>();
    }

    // Method to start a new session
    public Session startSession(User user) {
        Session session = new Session(user);
        activeSessions.add(session);
        return session;
    }

    // Method to stop a session
    public void stopSession(Session session) {
        activeSessions.remove(session);
    }

    // Method to check if a session is active
    public boolean isSessionActive(Session session) {
        return activeSessions.contains(session);
    }

    // Model class
    class Session {
        private User user;

        public java_13711_SessionManager_A07(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // User model class
    class User {
        private String username;
        private String password;

        public java_13711_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}