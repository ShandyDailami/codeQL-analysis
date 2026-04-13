import java.util.HashMap;
import java.util.Map;

public class java_29180_SessionManager_A01 {

    // Using a HashMap to store user sessions
    private Map<String, String> userSessions;

    public java_29180_SessionManager_A01() {
        userSessions = new HashMap<>();
    }

    // Method for a user to login
    public void login(String userId, String password) {
        if(isPasswordValid(userId, password)) {
            userSessions.put(userId, password);
        } else {
            throw new SecurityException("Invalid password for user " + userId);
        }
    }

    // Method for a user to logout
    public void logout(String userId) {
        userSessions.remove(userId);
    }

    // Method to check if the user's session is valid
    public boolean isSessionValid(String userId) {
        return userSessions.containsKey(userId);
    }

    // Method to check if the password is valid
    private boolean isPasswordValid(String userId, String password) {
        // Assume we have a method to get the password for a user
        // This method should be implemented in a secure way, not shown here
        return true;
    }
}