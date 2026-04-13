public class java_32879_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean isValid = true;

        // Check if password has at least one upper case letter
        if (password.regionMatches(1, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, password.length())) {
            hasUpperCase = true;
        }

        // Check if password has at least one lower case letter
        if (password.regionMatches(1, "abcdefghijklmnopqrstuvwxyz", 0, password.length())) {
            hasLowerCase = true;
        }

        // Check if password has at least one digit
        if (password.regionMatches(1, "0123456789", 0, password.length())) {
            hasDigit = true;
        }

        // Check if password has at least one special character
        if (password.regionMatches(1, "!@#$%^&*()_+", 0, password.length())) {
            hasSpecialChar = true;
        }

        // If all conditions are satisfied, return true else return false
        if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar && password.length() > 8) {
            return true;
        } else {
            return false;
        }
    }
}