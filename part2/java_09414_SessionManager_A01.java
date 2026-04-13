import java.util.HashMap;
import java.util.Map;

public class java_09414_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09414_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        // For the purpose of this example, we will store the passwords as plain text in memory
        // In a real application, you should never store passwords in plain text, for security reasons.
        // This is a simple demonstration of security-sensitive operations.
        String hashedPassword = password; 
        sessionMap.put(username, hashedPassword);
    }

    public String getSession(String username) {
        // For the purpose of this example, we will verify the session based on if the password is the same as stored in memory.
        // In a real application, you should never compare passwords directly in memory, for security reasons.
        // This is a simple demonstration of security-sensitive operations.
        String storedPassword = sessionMap.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return "Session started for user: " + username;
        } else {
            return "Failed to start session";
        }
    }
}