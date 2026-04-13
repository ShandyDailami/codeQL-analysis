import java.util.HashMap;
import java.util.Map;

public class java_37964_SessionManager_A01 {
    // A map to store user names and session IDs.
    private Map<String, String> userSessions;

    public java_37964_SessionManager_A01() {
        userSessions = new HashMap<>();
    }

    // Method to log in a user.
    public void login(String userID, String sessionID) {
        userSessions.put(userID, sessionID);
    }

    // Method to log out a user.
    public void logout(String userID) {
        userSessions.remove(userID);
    }

    // Method to check if a user is logged in.
    public boolean isLoggedIn(String userID) {
        return userSessions.containsKey(userID);
    }
}