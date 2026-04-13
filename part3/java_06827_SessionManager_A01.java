import java.util.HashMap;
import java.util.Map;

public class java_06827_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_06827_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValidCredentials(username, password)) {
            sessionMap.put(username, password);
        } else {
            throw new IllegalStateException("Invalid credentials");
        }
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    private boolean isValidCredentials(String username, String password) {
        // Placeholder for security check.
        // In reality, this could involve checking a database, calling a web service, etc.
        // Also, this should not be done in plain text. It should be hashed and compared to a stored hash.
        // In this example, we will just return true or false for simplicity.
        return username.equals("admin") && password.equals("password");
    }
}