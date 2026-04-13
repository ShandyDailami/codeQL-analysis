import java.util.HashMap;
import java.util.Map;

public class java_15315_SessionManager_A03 {
    private Map<String, String> sessions;
    private Map<String, String> passwords;

    public java_15315_SessionManager_A03() {
        sessions = new HashMap<>();
        passwords = new HashMap<>();
    }

    public void createSession(String username, String password) {
        // Hash the password
        String hashedPassword = hashPassword(password);
        // Store the session and password in the map
        sessions.put(username, hashedPassword);
        passwords.put(hashedPassword, username);
    }

    public String getSession(String username, String password) {
        // Hash the given password
        String hashedPassword = hashPassword(password);
        // If the hashed password matches the stored password, return the session
        if (sessions.get(username).equals(hashedPassword)) {
            return sessions.get(username);
        }
        return null;
    }

    private String hashPassword(String password) {
        // Implement a hashing algorithm here (e.g., SHA-256)
        // For the purpose of this example, we'll just return the input string
        return password;
    }
}