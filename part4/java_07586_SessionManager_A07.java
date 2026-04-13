import java.util.HashMap;
import java.util.Map;

public class java_07586_SessionManager_A07 {
    private static final Map<String, String> sessionMap = new HashMap<>();

    // Login method
    public String login(String username, String password) {
        // Adding some security-sensitive logic here to authenticate the user
        if (username.equals("admin") && password.equals("password")) {
            return "A07_AuthFailure";
        }
        return null;
    }

    // Logout method
    public void logout(String sessionId) {
        // Removing the session from the map
        sessionMap.remove(sessionId);
    }

    // Check if a session is valid
    public boolean isValidSession(String sessionId) {
        // Check if the session map contains the session
        return sessionMap.containsKey(sessionId);
    }
}