public class java_15608_CredentialValidator_A08 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public boolean validate(String username, String password, boolean rememberMe) {
        if (password == null || password.length() == 0) {
            return false;
        }

        int length = password.length();
        if (length < 8 || length > 16) {
            return false;
        }

        if (!containsDigit(password)) {
            return false;
        }

        if (!containsUppercaseLetter(password)) {
            return false;
        }

        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsUppercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (UPPERCASE_LETTERS.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }
}