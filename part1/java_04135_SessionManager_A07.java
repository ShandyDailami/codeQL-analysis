import java.util.HashMap;
import java.util.Map;

public class java_04135_SessionManager_A07 {

    private Map<String, String> sessions = new HashMap<>();

    public void createSession(String username, String password) {
        if (isValidCredentials(username, password)) {
            sessions.put(username, username);
        } else {
            throw new SecurityFailureException("Invalid credentials");
        }
    }

    public void destroySession(String username) {
        sessions.remove(username);
    }

    public String getSession(String username) {
        return sessions.get(username);
    }

    private boolean isValidCredentials(String username, String password) {
        // This is a simple example. In a real application, you'd want to hash and salt the password,
        // then compare the hashed password to a stored hash.
        return "password".equals(password); // Assuming password is always "password"
    }
}