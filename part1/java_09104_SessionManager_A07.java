import java.util.HashMap;
import java.util.Map;

public class java_09104_SessionManager_A07 {
    private Map<String, String> database;
    private Map<String, String> sessions;

    public java_09104_SessionManager_A07() {
        // Using a HashMap for simplicity, but in a real-world scenario
        // it would be better to use a more secure data structure
        database = new HashMap<>();
        sessions = new HashMap<>();

        // Add some sample data
        database.put("admin", "password");
        database.put("user", "password");
    }

    public String createSession(String username, String password) {
        // Check if the username/password combination is valid
        if (database.containsKey(username) && database.get(username).equals(password)) {
            // Generate a new session key
            String sessionKey = "session-" + System.currentTime();
            sessions.put(sessionKey, username);

            return sessionKey;
        } else {
            return null;
        }
    }

    public String getUsername(String sessionKey) {
        // Check if the session key exists in the sessions map
        if (sessions.containsKey(sessionKey)) {
            // Get the username from the session key
            String username = sessions.get(sessionKey);

            return username;
        } else {
            return null;
        }
    }

    public void endSession(String sessionKey) {
        // Remove the session key from the sessions map
        sessions.remove(sessionKey);
    }
}