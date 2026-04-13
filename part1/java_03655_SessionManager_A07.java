import java.util.HashMap;

public class java_03655_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_03655_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (isValid(username, password)) {
            sessions.put(username, password);
        } else {
            throw new SecurityFailureException("Invalid credentials");
        }
    }

    public String getSession(String username) {
        return sessions.get(username);
    }

    public void destroySession(String username) {
        sessions.remove(username);
    }

    private boolean isValid(String username, String password) {
        // Add your security-sensitive operations here
        // For example, you can check the database for the username and password
        // If they match, return true, else return false
        return true; // Remove this after testing
    }
}