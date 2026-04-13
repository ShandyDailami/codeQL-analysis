public class java_30948_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!containsUpperCase(password)) {
            return false;
        }

        if (!containsLowerCase(password)) {
            return false;
        }

        if (!containsNumber(password)) {
            return false;
        }

        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private static boolean containsUpperCase(String password) {
        return password.regionMatches(0, UPPERCASE, 0, password.length());
    }

    private static boolean containsLowerCase(String password) {
        return password.regionMatches(0, LOWERCASE, 0, password.length());
    }

    private static boolean containsNumber(String password) {
        return password.regionMatches(0, NUMBERS, 0, password.length());
    }

    private static boolean containsSpecialCharacter(String password) {
        return password.regionMatches(0, SPECIAL_CHARACTERS, 0, password.length());
    }
}