public class java_19934_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()_+=-[]\\\';,./{}|\":<>?^&";

    public static boolean validate(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        // Check for minimum length
        if (password.length() < 8) {
            return false;
        }

        // Check for upper case
        if (!containsUpperCase(password)) {
            return false;
        }

        // Check for lower case
        if (!containsLowerCase(password)) {
            return false;
        }

        // Check for digits
        if (!containsDigit(password)) {
            return false;
        }

        // Check for special characters
        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private static boolean containsUpperCase(String password) {
        return password.regionMatches(0, "(?=.*[A-Z])", 0, password.length());
    }

    private static boolean containsLowerCase(String password) {
        return password.regionMatches(0, "(?=.*[a-z])", 0, password.length());
    }

    private static boolean containsDigit(String password) {
        return password.regionMatches(0, "(?=.*[0-9])", 0, password.length());
    }

    private static boolean containsSpecialCharacter(String password) {
        return password.regionMatches(0, "(?=.*[" + SPECIAL_CHARACTERS + "])", 0, password.length());
    }
}