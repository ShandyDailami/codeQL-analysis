import java.util.HashMap;
import java.util.Map;

public class java_40641_SessionManager_A07 {
    // Create a map to store users and their sessions
    private Map<String, String> userSessionMap;

    public java_40641_SessionManager_A07() {
        userSessionMap = new HashMap<>();
    }

    // Method to authenticate a user
    public boolean authenticateUser(String userName, String password) {
        // Here, for simplicity, we're just checking if the user and password match
        // In a real application, you'd actually perform a check against a database here
        if (userName.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

    // Method to create a session for a user
    public String createSession(String userName) {
        // Generate a session id
        String sessionId = String.valueOf(System.nanoTime());

        // Store the session id and user name in the map
        userSessionMap.put(sessionId, userName);

        // Return the session id
        return sessionId;
    }

    // Method to validate a user's session
    public boolean validateSession(String sessionId) {
        // Check if the session id exists in the map
        if (userSessionMap.containsKey(sessionId)) {
            // Get the user name from the session id
            String userName = userSessionMap.get(sessionId);

            // Check if the user name is valid (it's actually "admin")
            if (userName.equals("admin")) {
                return true;
            }
        }
        return false;
    }

    // Method to end a user's session
    public void endSession(String sessionId) {
        // Remove the user name from the session id
        userSessionMap.remove(sessionId);
    }
}