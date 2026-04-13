public class java_39995_CredentialValidator_A07 {
    private static int failureCount = 0;
    private static final int MAX_FAILURE_ATTEMPTS = 3;

    public static boolean validateCredentials(String username, String password) {
        boolean isValid = false;

        // Step 1: Simulate authentication process with standard library
        if (simulateAuthentication(username, password)) {
            isValid = true;
            resetFailureCount();
        } else {
            incrementFailureCount();
       
            // Step 2: Check if maximum failure attempts reached
            if (isMaxFailureAttemptsReached()) {
                System.out.println("Maximum number of failed attempts reached. Account locked.");
            } else {
                System.out.println("Authentication failed. Please try again.");
            }
        }

        return isValid;
    }

    private static boolean simulateAuthentication(String username, String password) {
        // Step 3: Simulate authentication process with standard library
        // For simplicity, we will return true for valid credentials and false for invalid ones.
        return username.equals("admin") && password.equals("password");
    }

    private static void resetFailureCount() {
        // Step 4: Reset failure count to 0
        failureCount = 0;
    }

    private static void incrementFailureCount() {
        // Step 5: Increment failure count
        failureCount++;
    }

    private static boolean isMaxFailureAttemptsReached() {
        // Step 6: Check if maximum failure attempts reached
        return failureCount == MAX_FAILURE_ATTEMPTS;
    }
}