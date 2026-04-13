import java.util.HashMap;

public class java_00463_SessionManager_A03 {
    // In a real-world scenario, this would be a real database.
    private HashMap<String, String> userSessions;

    public java_00463_SessionManager_A03() {
        userSessions = new HashMap<>();
    }

    public void login(String username, String password) {
        // Simulate a login attempt.
        // This is a security-sensitive operation, so we should not do anything
        // if the provided credentials are incorrect.
        if (!isValidCredentials(username, password)) {
            throw new SecurityException("Invalid credentials");
        }

        // Store the session information.
        userSessions.put(username, "validSession");
    }

    public void logout(String username) {
        // Simulate a logout attempt.
        // Also, store the session information.
        if (userSessions.containsKey(username)) {
            userSessions.remove(username);
        }
    }

    public boolean isValidSession(String username) {
        // Check if the session information is valid.
        // In a real-world scenario, this would also involve validating the session
        // based on the stored session information.
        return userSessions.containsKey(username);
    }

    private boolean isValidCredentials(String username, String password) {
        // Simulate a validation attempt.
        // In a real-world scenario, this would involve checking if the provided
        // credentials match a predefined set of valid credentials.
        return username.equals("admin") && password.equals("password");
    }
}