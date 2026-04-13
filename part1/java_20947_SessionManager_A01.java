import java.util.HashMap;
import java.util.Map;

public class java_20947_SessionManager_A01 {
    // Private map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_20947_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String username) {
        sessionMap.put(username, "true");
    }

    // Method to end a session
    public void endSession(String username) {
        sessionMap.remove(username);
    }

    // Method to check if a session is active
    public boolean isSessionActive(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username).equals("true");
        } else {
            return false;
        }
    }

    // Method to check if a user is an administrator
    public boolean isAdmin(String username) {
        if (isSessionActive(username)) {
            return username.equals("admin");
        } else {
            return false;
        }
    }

    // Method to check if a user is a regular user
    public boolean isUser(String username) {
        if (isSessionActive(username)) {
            return !username.equals("admin");
        } else {
            return false;
        }
    }
}