import java.util.HashMap;
import java.util.Map;

public class java_41099_SessionManager_A07 {
    private Map<String, String> sessionData;
    private Map<String, String> userData;

    public java_41099_SessionManager_A07() {
        sessionData = new HashMap<>();
        userData = new HashMap<>();
    }

    public void startSession(String username, String password) {
        // For simplicity, we'll just store the username and password in the session
        sessionData.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        // For simplicity, we'll just check if the stored password is the same as the provided password
        return sessionData.containsKey(username) && sessionData.get(username).equals(password);
    }

    public boolean isValidSession(String username) {
        // Check if the user is in the session
        return sessionData.containsKey(username);
    }

    public void endSession(String username) {
        // Remove the user from the session
        sessionData.remove(username);
    }

    public void addUser(String username, String password) {
        // Store the user in the user data
        userData.put(username, password);
    }

    public boolean authenticateUser(String username, String password) {
        // Check if the user is in the user data and their password is correct
        return userData.containsKey(username) && userData.get(username).equals(password);
    }

    public boolean isValidUser(String username) {
        // Check if the user is in the user data
        return userData.containsKey(username);
    }
}