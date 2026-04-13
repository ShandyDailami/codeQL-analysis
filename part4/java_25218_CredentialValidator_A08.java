public class java_25218_CredentialValidator_A08 {

    // Minimum password length
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    // List of characters to check for strength
    private static final String STRENGTH_CHECK = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    // Check if password is strong enough
    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (STRENGTH_CHECK.indexOf(password.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
    }

}