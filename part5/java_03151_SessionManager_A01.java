import java.util.HashMap;
import java.util.Map;

public class java_03151_SessionManager_A01 {
    // In a real-world scenario, this would be stored in a database or secure storage
    private Map<String, String> userMap;

    public java_03151_SessionManager_A01() {
        this.userMap = new HashMap<>();
    }

    // Method to authenticate a user
    public String authenticate(String username, String password) {
        // This is a mock authentication and would be replaced with actual authentication logic
        if (username.equals("admin") && password.equals("password")) {
            return "AdminSession";
        }
        return null;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // In a real-world scenario, this would also involve checking the session against a list of valid session IDs
        // This is a simple check and would be replaced with actual session validation logic
        if (sessionId != null && sessionId.length() > 0) {
            if (userMap.containsKey(sessionId)) {
                return true;
            }
        }
        return false;
    }

    // Method to add a user to the session
    public void addUser(String sessionId, String username) {
        // In a real-world scenario, this would also involve storing the username in the session
        if (validateSession(sessionId)) {
            userMap.put(sessionId, username);
        }
    }

    // Method to get the username from the session
    public String getUsername(String sessionId) {
        if (validateSession(sessionId)) {
            return userMap.get(sessionId);
        }
        return null;
    }
}