import java.util.HashMap;
import java.util.Map;

public class java_40037_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_40037_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValidUser(username, password)) {
            sessionMap.put(username, "Session active");
        } else {
            throw new SecurityException("Invalid username or password");
        }
    }

    public void endSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
        } else {
            throw new SecurityException("No active session for user");
        }
    }

    public String getSession(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            throw new SecurityException("No active session for user");
        }
    }

    private boolean isValidUser(String username, String password) {
        // This is a placeholder for a more secure method to check against a database
        // You would replace this with actual code to verify the username and password against a database
        return username.equals("admin") && password.equals("password");
    }
}