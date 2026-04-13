import java.util.HashMap;

public class java_03438_SessionManager_A07 {
    private HashMap<String, User> sessionMap;

    public java_03438_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(User user) {
        // Create a session ID using user's ID
        String sessionId = user.getId();

        // Store the user object in the session map
        sessionMap.put(sessionId, user);
    }

    public User getUserBySessionId(String sessionId) {
        // If the session ID exists in the map, return the corresponding User object
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // If the session ID is not found in the map, return null
            return null;
        }
    }

    public void endSession(String sessionId) {
        // Remove the user object from the session map
        sessionMap.remove(sessionId);
    }
}

public class User {
    private String id;

    public java_03438_SessionManager_A07(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}