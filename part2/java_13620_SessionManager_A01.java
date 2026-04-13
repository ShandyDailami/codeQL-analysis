import java.util.HashMap;
import java.util.Map;

public class java_13620_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_13620_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (!isValidCredentials(username, password)) {
            throw new SecurityException("Invalid credentials");
        }
        sessions.put(username, password);
    }

    public String getSession(String username) {
        String password = sessions.get(username);
        if (password == null) {
            throw new SecurityException("Session not found");
        }
        return password;
    }

    public void deleteSession(String username) {
        sessions.remove(username);
    }

    private boolean isValidCredentials(String username, String password) {
        // This is a stub, replace with actual implementation
        // It's a simple check for now. In a real application, passwords should be hashed and compared securely.
        return username.equals("admin") && password.equals("password");
    }
}