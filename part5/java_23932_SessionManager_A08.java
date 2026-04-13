import java.util.HashMap;

public class java_23932_SessionManager_A08 {
    private HashMap<String, User> sessions;
    private HashMap<String, User> users;

    public java_23932_SessionManager_A08() {
        this.sessions = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getID(), user);
    }

    public void startSession(User user) {
        String sessionID = generateSessionID();
        this.sessions.put(sessionID, user);
    }

    public User getUserFromSession(String sessionID) {
        return this.sessions.get(sessionID);
    }

    private String generateSessionID() {
        // This is a placeholder for generating a unique session ID.
        // In a real-world application, you would use a UUID or similar to ensure uniqueness.
        return "sessionID";
    }
}

class User {
    private String ID;

    public java_23932_SessionManager_A08(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}