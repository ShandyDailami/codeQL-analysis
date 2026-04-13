public class java_13465_SessionManager_A07 {
    // Predefined user credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Check if the given username and password match
    public static boolean checkCredentials(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    // Start a session if the given username and password match
    public static void startSession(String username, String password) throws AuthFailureException {
        if (!checkCredentials(username, password)) {
            throw new AuthFailureException("Invalid username or password");
        }
        // Start the session here
    }
}