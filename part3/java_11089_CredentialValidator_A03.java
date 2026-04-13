public class java_11089_CredentialValidator_A03 {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean validate(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasUppercaseLetter(password)) {
            return false;
        }

        if (!hasLowercaseLetter(password)) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasUppercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (UPPERCASE_LETTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (LOWERCASE_LETTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (DIGITS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}