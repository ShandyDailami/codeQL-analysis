public class java_14992_CredentialValidator_A03 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasUpperCaseLetter(password)) {
            return false;
        }

        if (!hasLowerCaseLetter(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private static boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean hasUpperCaseLetter(String password) {
        return password.matches(".*[ " + UPPERCASE_LETTERS + "]*");
    }

    private static boolean hasLowerCaseLetter(String password) {
        return password.matches(".*[ " + LOWERCASE_LETTERS + "]*");
    }

    private static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "]*");
    }
}