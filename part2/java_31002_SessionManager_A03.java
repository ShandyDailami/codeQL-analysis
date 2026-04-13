import java.util.ArrayList;
import java.util.List;

public class java_31002_SessionManager_A03 {
    // Hard-coded list of valid users.
    private static final List<String> VALID_USERS = new ArrayList<>(List.of("user1", "user2", "user3"));

    // This is a dummy authentication method. In a real application, it would use a secure method of authentication.
    private boolean authenticate(String user, String password) {
        // This is a simplified example. In a real application, you should use a secure method of authentication.
        return VALID_USERS.contains(user) && password.equals("password");
    }

    // This method starts a session for a user.
    public void startSession(String user, String password) throws SecurityException {
        if (!authenticate(user, password)) {
            throw new SecurityException("Invalid user or password");
        }
        // ... rest of the session code ...
    }

    // This method ends a session for a user.
    public void endSession(String user, String password) throws SecurityException {
        if (!authenticate(user, password)) {
            throw new SecurityException("Invalid user or password");
        }
        // ... rest of the session code ...
    }
}