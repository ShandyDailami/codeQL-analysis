public class java_28330_CredentialValidator_A03 {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String ALL_ALLOWED_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;

    public boolean isPasswordStrongEnough(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!containsUppercaseLetter(password)) {
            return false;
        }

        if (!containsLowercaseLetter(password)) {
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

    private boolean containsUppercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (UPPERCASE_LETTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLowercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (LOWERCASE_LETTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNumber(String password) {
        for (char c : password.toCharArray()) {
            if (NUMBERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}