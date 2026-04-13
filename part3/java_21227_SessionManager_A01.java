import java.util.HashMap;
import java.util.Map;

public class java_21227_SessionManager_A01 {
    // Initialize a HashMap to store users and their sessions.
    private Map<String, String> userSessionMap;

    // Initialize the session manager.
    public java_21227_SessionManager_A01() {
        userSessionMap = new HashMap<>();
    }

    // Method to login a user.
    public void login(String user, String sessionId) {
        userSessionMap.put(user, sessionId);
    }

    // Method to logout a user.
    public void logout(String user) {
        userSessionMap.remove(user);
    }

    // Method to check if a user is logged in.
    public boolean isLoggedIn(String user) {
        return userSessionMap.containsKey(user);
    }

    // Method to get the sessionId of a user.
    public String getSessionId(String user) {
        return userSessionMap.get(user);
    }
}