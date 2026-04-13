public class java_13906_CredentialValidator_A08 {

    // Hardcoded list of allowed usernames and passwords.
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("admin", "user1", "user2");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    // Number of allowed attempts before a user is locked out.
    private static final int ALLOWED_FAILURE_ATTEMPTS = 3;
    private static int failureAttempts = 0;

    public static boolean validate(String username, String password) {
        if (isAttemptAllowed()) {
            return ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password);
        } else {
            System.out.println("Access to the system is currently restricted due to multiple failed attempts.");
            return false;
        }
    }

    private static boolean isAttemptAllowed() {
        return failureAttempts < ALLOWED_FAILURE_ATTEMPTS;
    }

    public static void resetAttempts() {
        failureAttempts = 0;
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        System.out.println(validate("admin", "password1")); // Should print true
        System.out.println(validate("admin", "wrongpassword")); // Should print false
        System.out.println(validate("nonadmin", "password1")); // Should print false
        System.out.println(validate("admin", "password3")); // Should print false

        // Reset the attempts
        resetAttempts();

        System.out.println(validate("admin", "password1")); // Should print true
        System.out.println(validate("admin", "password3")); // Should print true
    }
}