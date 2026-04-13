import java.security.Permission;
import java.security.SecurityPermission;
import java.security.SecurityException;

public class java_24123_SessionManager_A07 {
    private String sessionId;

    public java_24123_SessionManager_A07(String sessionId) {
        this.sessionId = sessionId;
    }

    public void startSession() {
        // Simulate authenticating and authorizing the user.
        if (authenticateUser() && authorizeUser()) {
            System.out.println("Session started for user: " + sessionId);
        } else {
            throw new SecurityException("User not authenticated or not authorized.");
        }
    }

    private boolean authenticateUser() {
        // Implementation of user authentication.
        // For simplicity, just return true or false.
        return sessionId != null;
    }

    private boolean authorizeUser() {
        // Implementation of user authorization.
        // For simplicity, just return true or false.
        return true;
    }

    public static void main(String[] args) {
        // Create a session manager for user "admin".
        SessionManager sessionManager = new SessionManager("admin");

        // Start the session.
        sessionManager.startSession();
    }
}