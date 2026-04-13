import java.util.HashMap;
import java.util.UUID;

public class java_24131_SessionManager_A07 {

    private HashMap<UUID, User> sessions;

    public java_24131_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public UUID startSession(User user) {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public User getUser(UUID sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionActive(UUID sessionId) {
        return sessions.containsKey(sessionId);
    }

    public void checkAuthFailure(UUID sessionId) {
        if (!isSessionActive(sessionId)) {
            throw new SecurityException("Invalid session id");
        }

        User user = getUser(sessionId);
        if (user.isAuthenticated()) {
            System.out.println("User " + user.getName() + " is authenticated");
        } else {
            System.out.println("Authentication failure for user " + user.getName());
            endSession(sessionId);
            throw new SecurityException("Authentication failure");
        }
    }
}

public class User {

    private String name;
    private boolean authenticated;

    public java_24131_SessionManager_A07(String name) {
        this.name = name;
        this.authenticated = false;
    }

    public String getName() {
        return name;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void authenticate() {
        this.authenticated = true;
    }
}