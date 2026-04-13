import javax.management.AuthenticationFailureException;

public class java_37344_SessionManager_A07 {
    // Private instance of the SessionManager for singleton pattern
    private static SessionManager sessionManager = null;

    // Private constructor to prevent instantiation of a new SessionManager
    private java_37344_SessionManager_A07() {}

    // Public method to get the instance of the SessionManager
    public static SessionManager getInstance() {
        if(sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Method to validate user credentials
    public boolean validateUser(String username, String password) throws AuthenticationFailureException {
        // Here we could call our authentication service, if we're using a third-party service
        // If it fails, it would throw an AuthenticationFailureException
        // For now, we'll just simulate the authentication failure
        if (!username.equals("admin") || !password.equals("password")) {
            throw new AuthenticationFailureException("Invalid username or password");
        }

        // If the credentials are correct, return true
        return true;
    }

    // Method to start a session
    public void startSession(String username) {
        // Here, you can log the session start, and if needed, store the username in a session
        System.out.println("Session started for user: " + username);
    }

    // Method to end a session
    public void endSession(String username) {
        // Here, you can log the session end, and if needed, remove the username from a session
        System.out.println("Session ended for user: " + username);
    }
}