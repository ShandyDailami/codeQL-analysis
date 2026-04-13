import java.util.HashMap;

public class java_39272_SessionManager_A08 {
    // This is a simple hashmap that will serve as our session store
    private HashMap<String, Session> sessions = new HashMap<>();

    // A session represents a user's session in the system
    public class Session {
        private String userID;

        public java_39272_SessionManager_A08(String userID) {
            this.userID = userID;
        }

        public String getUserID() {
            return this.userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }
    }

    // This method will create a new session
    public Session createSession(String userID) {
        Session session = new Session(userID);
        sessions.put(userID, session);
        return session;
    }

    // This method will retrieve a session
    public Session getSession(String userID) {
        return sessions.get(userID);
    }

    // This method will delete a session
    public void deleteSession(String userID) {
        sessions.remove(userID);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session
        Session session = sessionManager.createSession("user1");
        System.out.println("Created session with userID: " + session.getUserID());

        // Retrieving a session
        Session retrievedSession = sessionManager.getSession("user1");
        System.out.println("Retrieved session with userID: " + retrievedSession.getUserID());

        // Deleting a session
        sessionManager.deleteSession("user1");
        System.out.println("Deleted session with userID: " + retrievedSession.getUserID());
    }
}