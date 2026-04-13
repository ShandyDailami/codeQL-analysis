public class java_23326_CredentialValidator_A07 {

    public static boolean isPasswordStrong(String password) {
        // check if password is null
        if (password == null) {
            return false;
        }

        // check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // check if password contains at least one uppercase letter, one lowercase letter, one digit, and one special character
        if (!hasUpperCase(password)) {
            return false;
        }
        if (!hasLowerCase(password)) {
            return false;
        }
        if (!hasDigit(password)) {
            return false;
        }
        if (!hasSpecialChar(password)) {
            return false;
        }

        return true;
    }

    private static boolean hasUpperCase(String password) {
        // use regular expression to check if password contains uppercase letter
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        // use regular expression to check if password contains lowercase letter
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        // use regular expression to check if password contains digit
        return password.matches(".*[0-9].*");
    }

    private static boolean hasSpecialChar(String password) {
        // use regular expression to check if password contains special character
        return password.matches(".*[~!@#$%^&*()_+=-].*");
    }
}