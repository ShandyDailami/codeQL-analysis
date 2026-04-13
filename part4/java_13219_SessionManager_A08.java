public class java_13219_SessionManager_A08 {
    // Private field to store the user's session
    private UserSession userSession;

    // Constructor to initialize the session manager
    public java_13219_SessionManager_A08() {
        userSession = null;
    }

    // Method to start a session for a user
    public void startSession(User user) {
        // Verify the user's integrity
        if (user.hasValidId() && user.hasValidPassword()) {
            // Set the user's session
            userSession = new UserSession(user);
            // Log the session start
            System.out.println("Session started for user: " + user.getUsername());
        } else {
            // Handle the integrity failure
            System.out.println("IntegrityFailure: User not valid.");
            // Throw an exception or handle the error in a way that fits your use case
            throw new IntegrityFailureException("User not valid");
        }
    }

    // Method to end a session for a user
    public void endSession() {
        // Verify the user's session exists
        if (userSession != null) {
            // Log the session end
            System.out.println("Session ended for user: " + userSession.getUser().getUsername());
            // Clean up the user's session
            userSession = null;
        } else {
            // Handle the session not found error
            System.out.println("SessionNotFound: No active session found.");
            // Throw an exception or handle the error in a way that fits your use case
            throw new SessionNotFoundException("No active session found");
        }
    }
}