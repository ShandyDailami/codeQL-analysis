public class java_39820_CredentialValidator_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void validate(String enteredUsername, String enteredPassword) {
        if (!enteredUsername.equals(USERNAME) || !enteredPassword.equals(PASSWORD)) {
            throw new AuthFailure();
        }
    }

    // Custom exception for authentication failure
    public static class AuthFailure extends RuntimeException {
        public java_39820_CredentialValidator_A07() {
            super("Authentication failure");
        }
    }

    public static void main(String[] args) {
        // Hardcoded credentials, you should use a real authentication service
        validate("username", "password");
    }
}