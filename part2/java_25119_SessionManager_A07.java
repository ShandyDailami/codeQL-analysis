import java.util.HashMap;
import java.util.Map;

public class java_25119_SessionManager_A07 {
    // Using a HashMap to store sessions. In a real application, you would use a database.
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to authenticate a user.
    public boolean authenticate(String username, String password) {
        // This is a dummy authentication. In a real application, you would call an authentication service.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

    // Method to create a new session.
    public void createSession(String username) {
        // In a real application, you would generate a unique session id.
        String sessionId = "sessionId";
        sessionMap.put(sessionId, username);
    }

    // Method to get the username for a given session.
    public String getSessionUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end the session for a given username.
    public void endSession(String username) {
        // Finding the session id for the given username.
        String sessionId = null;
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(username)) {
                sessionId = entry.getKey();
                break;
            }
        }
        // Removing the session id from the map.
        if (sessionId != null) {
            sessionMap.remove(sessionId);
        }
    }
}