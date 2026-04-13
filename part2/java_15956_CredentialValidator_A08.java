public class java_15956_CredentialValidator_A08 {
    private static int failureAttempts = 0;
    private static final int MAX_FAILURE_ATTEMPTS = 3;

    public static boolean validateCredentials(String username, String password) {
        // Placeholder for actual login process.
        boolean loginSuccessful = performLogin(username, password);

        if (!loginSuccessful) {
            failureAttempts++;

            if (failureAttempts >= MAX_FAILURE_ATTEMPTS) {
                System.out.println("Too many failed attempts. Account locked.");
                failureAttempts = 0;
            } else {
                System.out.println("Incorrect username or password. Attempts remaining: " + (MAX_FAILURE_ATTEMPTS - failureAttempts));
            }
        } else {
            failureAttempts = 0;
            System.out.println("Login successful.");
        }

        return loginSuccessful;
    }

    private static boolean performLogin(String username, String password) {
        // Placeholder for actual login process.
        // This method should handle the actual login process.
        // For demonstration purposes, we'll return a static value.
        return username.equals("admin") && password.equals("password");
    }
}