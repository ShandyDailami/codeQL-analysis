public class java_10026_SessionManager_A07 {

    private static int sessionCount = 0;

    // Session constructor
    public java_10026_SessionManager_A07() {
        sessionCount++;
        System.out.println("Created session: " + sessionCount);
    }

    // Session method
    public void performAction(String action) {
        if (action.equals("auth")) {
            System.out.println("Authenticating user...");
            // Simulate a failure if authentication fails
            if (sessionCount % 10 == 5) {
                System.out.println("Authentication failed.");
                throw new AuthFailureException();
            } else {
                System.out.println("Authentication successful.");
            }
        } else if (action.equals("logout")) {
            System.out.println("Logging out user...");
            sessionCount--;
            System.out.println("User logged out.");
        } else {
            System.out.println("Unknown action: " + action);
        }
    }
}