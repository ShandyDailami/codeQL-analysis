import java.util.HashMap;
import java.util.Map;

public class java_35021_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_35021_SessionManager_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateSession(String username, String password) {
        return this.credentials.get(username).equals(password);
    }

    public void establishSession(String username) {
        if (!validateSession(username, username)) {
            throw new SecurityException("Invalid credentials");
        }
        // Session established, store the username in a session attribute
    }

    public void endSession(String username) {
        // Session ended, remove the username from the session attribute
    }
}