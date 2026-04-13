import java.util.HashMap;
import java.util.Map;

public class java_02999_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_02999_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username, String password) {
        // This is a dummy password hashing function for the sake of simplicity.
        // In a real application, passwords should not be stored in plain text.
        String hashedPassword = hashPassword(password);
        sessions.put(username, hashedPassword);
        return username;
    }

    public String getSession(String username, String password) {
        String hashedPassword = sessions.get(username);

        // This is a dummy password verification function for the sake of simplicity.
        // In a real application, passwords should be verified against the stored hash.
        if (hashedPassword != null && hashedPassword.equals(hashPassword(password))) {
            return username;
        } else {
            throw new AuthFailureException();
        }
    }

    private String hashPassword(String password) {
        // Dummy function for the sake of simplicity. In a real application, passwords should be hashed using a secure method.
        return password;
    }

    private static class AuthFailureException extends RuntimeException {
        // Custom exception to handle authentication failure.
    }
}