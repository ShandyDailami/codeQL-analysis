import java.util.ArrayList;
import java.util.List;

public class java_13459_SessionManager_A01 {
    // Use an ArrayList to store sessions
    private List<Session> sessions;

    public java_13459_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    // Method to start a new session
    public Session startSession(User user) {
        Session session = new Session(user);
        sessions.add(session);
        return session;
    }

    // Method to end a session
    public void endSession(Session session) {
        sessions.remove(session);
        // Clear the session data
        session.getUser().clearData();
    }

    // Session class
    public class Session {
        private User user;

        public java_13459_SessionManager_A01(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // User class
    public class User {
        private String data;

        public java_13459_SessionManager_A01(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void clearData() {
            this.data = null;
        }
    }
}