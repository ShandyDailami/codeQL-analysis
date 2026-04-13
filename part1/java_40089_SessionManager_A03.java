public class java_40089_SessionManager_A03 {
    // In a real-world application, this would be a map where the key is the session id and the value is the user object
    private Map<String, User> sessions;

    public java_40089_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // This method creates a new session
    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString(); // Generate a new session id
        sessions.put(sessionId, user); // Store the user object in the session map
        return sessionId;
    }

    // This method retrieves a user based on the session id
    public User getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    // This method destroys a session
    public void destroySession(String sessionId) {
        sessions.remove(sessionId); // Remove the session from the map
    }
}

public class User {
    private String name;

    public java_40089_SessionManager_A03(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}