public class java_11545_CredentialValidator_A07 {
    public static final String SPECIAL_CHARS = "!@#$%^&*()";
    public static final String NUMBER_CHARS = "1234567890";
    public static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!containsSpecialChar(password)) {
            return false;
        }

        if (!containsNumber(password)) {
            return false;
        }

        if (!containsUpperCase(password)) {
            return false;
        }

        if (!containsLowerCase(password)) {
            return false;
        }

        return true;
    }

    private static boolean containsSpecialChar(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsNumber(String password) {
        for (char c : password.toCharArray()) {
            if (NUMBER_CHARS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (UPPERCASE_CHARS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (LOWERCASE_CHARS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}