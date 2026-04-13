public class java_40229_CredentialValidator_A07 {
    private static final String UPPERCASE_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_+=-";
    private static final String ALLOWED_SPECIAL_CHARACTERS = SPECIAL_CHARACTERS + UPPERCASE_LETTER + LOWERCASE_LETTER + NUMBER;

    public boolean isPasswordStrongEnough(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!containsLowercaseLetter(password)) {
            return false;
        }

        if (!containsUppercaseLetter(password)) {
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
        for (int i = 0; i < password.length(); i++) {
            if (UPPERCASE_LETTER.indexOf(password.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLowercaseLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (LOWERCASE_LETTER.indexOf(password.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (NUMBER.indexOf(password.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (ALLOWED_SPECIAL_CHARACTERS.indexOf(password.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }
}