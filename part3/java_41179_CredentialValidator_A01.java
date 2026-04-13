public class java_41179_CredentialValidator_A01 {
    // Constants
    private static final int PASSWORD_MIN_LENGTH = 8;

    // Methods
    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        // Check if password is at least PASSWORD_MIN_LENGTH characters long
        if (password.length() >= PASSWORD_MIN_LENGTH) {
            return true;
        }

        return false;
    }
}