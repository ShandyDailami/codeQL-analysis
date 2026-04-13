import java.util.HashSet;
import java.util.Set;

public class java_09391_CredentialValidator_A07 {
    // Create a HashSet to store failed attempts
    private Set<String> failedAttempts = new HashSet<>();

    // Maximum number of allowed attempts
    private static final int MAX_FAILED_ATTEMPTS = 3;

    // The username to be validated
    private String username;

    // Constructor
    public java_09391_CredentialValidator_A07(String username) {
        this.username = username;
    }

    // Method to validate the credentials
    public boolean validateCredentials(String password) {
        // Simulate a failed attempt
        if (failedAttempts.contains(password)) {
            failedAttempts.remove(password);
            return false;
        }

        // Assume the password is correct for this example
        if (password.equals("correct_password")) {
            failedAttempts.clear();
            return true;
        } else {
            failedAttempts.add(password);
            if (failedAttempts.size() >= MAX_FAILED_ATTEMPTS) {
                // Block the user
                System.out.println("Blocked " + username);
                failedAttempts.clear();
                return false;
            }
            return false;
        }
    }

    // Method to forcefully block the user
    public void forceBlockUser() {
        if (!failedAttempts.isEmpty()) {
            System.out.println("Blocked " + username);
            failedAttempts.clear();
        }
    }
}