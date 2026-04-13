public class java_04800_CredentialValidator_A01 {
    public static boolean isPasswordStrong(String password) {
        // ensure the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // ensure the password contains a digit and a special character
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        if (!password.matches(".*[!@#$%^&*()_+=\\-{}\\:[\\\";'<,>].*")) {
            return false;
        }

        // password is strong if it passes all these checks
        return true;
    }
}