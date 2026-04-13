import java.util.*;

class java_38887_SessionManager_A03 {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}

class SessionManager {
    private Map<String, User> sessions;

    public SessionManager() {
        this.sessions = new HashMap<>();
    }

    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        this.sessions.put(sessionId, user);
        return sessionId;
    }

    public User getUserFromSession(String sessionId) {
        return this.sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessions.remove(sessionId);
    }
}

class Main {
    public static void main(String[] args) {
        User user = new User("alice", "password");
        SessionManager manager = new SessionManager();
        String sessionId = manager.createSession(user);
        System.out.println("Created session ID: " + sessionId);

        User retrievedUser = manager.getUserFromSession(sessionId);
        System.out.println("Retrieved user: " + retrievedUser.getUsername());

        manager.deleteSession(sessionId);
        System.out.println("Deleted session ID: " + sessionId);
    }
}