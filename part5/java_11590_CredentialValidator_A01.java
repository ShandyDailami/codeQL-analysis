public class java_11590_CredentialValidator_A01 {

    // Define a rule for strength
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    // CredentialValidator is an interface, we can't create an instance of it
    private java_11590_CredentialValidator_A01() {}

    // Public method to check the password strength
    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        // Check if the password length is at least 8 characters
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return false;
        }

        // More checks can be added here for more strength requirements

        return true;
    }
}