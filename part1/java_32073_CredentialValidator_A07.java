public class java_32073_CredentialValidator_A07 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";

    public boolean isValid(String password) {
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

        if (!hasNumber(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasUppercaseLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (UPPERCASE_LETTERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowercaseLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (LOWERCASE_LETTERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (NUMBERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}