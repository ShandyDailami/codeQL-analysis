public class java_05453_CredentialValidator_A08 {

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

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
        return password.regionMatches(0, "(?i)^[A-Z]*$", 0, password.length());
    }

    private static boolean hasLowerCase(String password) {
        return password.regionMatches(0, "(?i)^[a-z]*$", 0, password.length());
    }

    private static boolean hasDigit(String password) {
        return password.regionMatches(0, "(?i)\\d", 0, password.length());
    }

    private static boolean hasSpecialChar(String password) {
        return password.regionMatches(0, "(?i)[\\p{P}\\p{Z}]", 0, password.length());
    }
}