public class java_01967_CredentialValidator_A08 {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String ALL_ALLOWED = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!containsUppercaseLetter(password)) {
            return false;
        }

        if (!containsLowercaseLetter(password)) {
            return false;
        }

        if (!containsDigit(password)) {
            return false;
        }

        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private static boolean containsUppercaseLetter(String password) {
        return password.regionMatches(true, 0, UPPERCASE_LETTERS, 0, UPPERCASE_LETTERS.length());
    }

    private static boolean containsLowercaseLetter(String password) {
        return password.regionMatches(true, 0, LOWERCASE_LETTERS, 0, LOWERCASE_LETTERS.length());
    }

    private static boolean containsDigit(String password) {
        return password.regionMatches(true, 0, DIGITS, 0, DIGITS.length());
    }

    private static boolean containsSpecialCharacter(String password) {
        return password.regionMatches(true, 0, SPECIAL_CHARACTERS, 0, SPECIAL_CHARACTERS.length());
    }

    public static void main(String[] args) {
        String password = "Aa1@Aa!";
        if (isValidPassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }
}