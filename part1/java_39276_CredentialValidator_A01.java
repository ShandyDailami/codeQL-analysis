public class java_39276_CredentialValidator_A01 {

    // A simple password strength checker.
    // Returns true if the password is strong enough.

    public static boolean isPasswordStrong(String password) {
        // Check if password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if password contains a letter
        if (!password.matches(".*[a-zA-Z].*")) {
            return false;
        }

        // Check if password contains a special character
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String password = "strongPassword123";
        System.out.println(isPasswordStrong(password));
    }
}