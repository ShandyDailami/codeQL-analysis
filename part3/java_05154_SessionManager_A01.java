import java.util.HashMap;
import java.util.Map;

public class java_05154_SessionManager_A01 {
    // A simple in-memory storage for authenticated users
    private Map<String, String> userMap = new HashMap<>();

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        // This is a simple in-memory authentication. In a real-world application, you should use a secure mechanism like bcrypt for password hashing.
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }
        return false;
    }

    // Method to check if a user is authenticated
    public boolean isAuthenticated(String username) {
        return userMap.containsKey(username);
    }

    // Method to start a session for a user
    public void startSession(String username) {
        if (authenticate(username, "password")) {
            userMap.put(username, "authenticated");
        } else {
            throw new SecurityException("Unable to authenticate user");
        }
    }

    // Method to end a session for a user
    public void endSession(String username) {
        userMap.remove(username);
    }

    // Method to get the status of a user's session
    public String getSessionStatus(String username) {
        if (userMap.containsKey(username)) {
            return userMap.get(username);
        } else {
            throw new SecurityException("User is not authenticated");
        }
    }
}