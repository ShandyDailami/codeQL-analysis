public class java_10382_SessionManager_A07 {

    // Session manager will not manage sessions if it's not used
    // so we will use this as a flag to check if a session is active or not
    private static boolean isSessionActive = false;

    // This method will check if a session is active or not
    public static boolean isSessionActive() {
        return isSessionActive;
    }

    // This method will set a session as active
    public static void setSessionActive(boolean sessionActive) {
        isSessionActive = sessionActive;
    }

    // This method will check if the session is active
    public static void checkSession() {
        if (!isSessionActive()) {
            throw new AuthenticationFailureException("Session not active");
        }
    }

    // This method will throw an exception if the session is not active
    public static void authenticateUser(String user, String password) {
        // Simulating database authentication
        if (user.equals("admin") && password.equals("password")) {
            setSessionActive(true);
        } else {
            throw new AuthenticationFailureException("Authentication failed");
        }
    }
}