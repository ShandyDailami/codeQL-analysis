import javax.management.RuntimeErrorException;

public class java_16080_SessionManager_A07 {
    private User currentUser;
    private Session currentSession;

    public void login(String username, String password) throws AuthenticationFailureException {
        // Simulating authentication process
        if (!authenticate(username, password)) {
            throw new AuthenticationFailureException();
        }

        // Successful authentication, create a new session
        currentSession = new Session();
        currentUser = new User(username);
    }

    private boolean authenticate(String username, String password) {
        // Simulating authentication process
        // This is a very basic form of authentication. In a real-world application, you would want to use
        // a secure and more complex method of authentication.
        return username.equals("admin") && password.equals("password");
    }

    public void logout() {
        // Close the current session
        if (currentSession != null) {
            currentSession.close();
            currentSession = null;
        }

        // Reset the user
        if (currentUser != null) {
            currentUser.clearCredentials();
            currentUser = null;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Session getCurrentSession() {
        return currentSession;
    }
}

class AuthenticationFailureException extends RuntimeErrorException {
    public java_16080_SessionManager_A07() {
        super("Authentication failed");
    }
}

class User {
    private String username;

    public java_16080_SessionManager_A07(String username) {
        this.username = username;
    }

    public void clearCredentials() {
        // Clear sensitive information (e.g., password)
    }

    public String getUsername() {
        return username;
    }
}

class Session {
    private boolean isOpen;

    public java_16080_SessionManager_A07() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
}