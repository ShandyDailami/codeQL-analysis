import java.util.HashMap;
import java.util.Map;

public class java_29930_SessionManager_A07 {
    // Use a HashMap to store sessions.
    private Map<String, Session> sessions;

    public java_29930_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Session class.
    public class Session {
        private String userID;

        public java_29930_SessionManager_A07(String userID) {
            this.userID = userID;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }
    }

    // Method to create a new session.
    public Session createSession(String userID) {
        Session session = new Session(userID);
        sessions.put(userID, session);
        return session;
    }

    // Method to validate a session.
    public boolean validateSession(String userID, String password) {
        // In a real application, you would need to verify the user's password against a secure hash
        // or database. This is not included in this example.
        Session session = sessions.get(userID);
        if (session != null) {
            // If the session exists and the password is correct, return true.
            return session.getUserID().equals(userID);
        } else {
            // If the session does not exist, return false.
            return false;
        }
    }
}