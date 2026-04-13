import java.util.HashSet;
import java.util.Set;

public class java_17119_CredentialValidator_A01 {
    // Set to store the failed login attempts
    private Set<String> failedAttempts = new HashSet<>();

    // Maximum number of allowed failed attempts
    private static final int MAX_FAILED_ATTEMPTS = 3;

    // Maximum allowed time in seconds between failed attempts
    private static final int MAX_FAILED_TIME = 60;

    // Time in seconds when a failed attempt is allowed again
    private static final int ALLOWED_TIME_BETWEEN_FAILED_ATTEMPTS = 10;

    // Flag to track if the last attempt was within the allowed time
    private boolean isAllowedToAttempt = true;

    public boolean validate(String username, String password) {
        // Assume a user is valid if he is not in the failed attempts set
        boolean isValid = failedAttempts.contains(username);

        // Check if the password is correct
        if (isValid) {
            isValid = password.equals("correct_password");
        }

        // Reset the failed attempts flag
        isAllowedToAttempt = true;

        return isValid;
    }

    public void failedAttempt(String username) {
        if (isAllowedToAttempt) {
            failedAttempts.add(username);
            isAllowedToAttempt = false;
        } else {
            System.out.println("Too many failed attempts. Please wait for " + MAX_FAILED_TIME + " seconds before attempting again.");
        }
    }
}