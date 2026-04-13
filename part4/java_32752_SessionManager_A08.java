import java.util.HashMap;
import java.util.Map;

public class java_32752_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_32752_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String user, String password) {
        // This is a placeholder for a secure authentication process
        // We will not be hashing passwords here for simplicity
        if (authenticate(user, password)) {
            String sessionKey = generateSessionKey(user);
            sessions.put(sessionKey, user);
        } else {
            throw new SecurityException("Authentication failed");
        }
    }

    public void validateSession(String sessionKey) {
        if (sessions.containsKey(sessionKey)) {
            String user = sessions.get(sessionKey);
            System.out.println("Validated session for user: " + user);
        } else {
            throw new SecurityException("Invalid session key");
        }
    }

    private boolean authenticate(String user, String password) {
        // This is a placeholder for a secure password checking process
        // We will not be comparing passwords here for simplicity
        return true;
    }

    private String generateSessionKey(String user) {
        // This is a placeholder for a secure session key generation process
        // We will not be using the user's full name or any other sensitive data for simplicity
        return user;
    }
}