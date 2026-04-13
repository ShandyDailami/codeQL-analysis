public class java_23690_SessionManager_A01 {
    private int sessionCount;

    // SessionManager Constructor
    public java_23690_SessionManager_A01() {
        sessionCount = 0;
    }

    // Method for logging in a user
    public void logIn(String username, String password) {
        // This is a placeholder for a real login function. 
        // The actual implementation may involve calling a database query, hashing the password, etc.
        // For the purpose of this example, we'll just increment the session count.
        sessionCount++;
        System.out.println("User " + username + " logged in. Sessions so far: " + sessionCount);
    }

    // Method for logging out a user
    public void logOut() {
        // Decrement session count.
        sessionCount--;
        System.out.println("User logged out. Sessions so far: " + sessionCount);
    }

    // Check if the user is logged in
    public boolean isLoggedIn() {
        // Always return true if session count is greater than 0.
        // This is a placeholder for a real logged-in status check.
        return sessionCount > 0;
    }
}