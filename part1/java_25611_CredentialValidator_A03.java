public class java_25611_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";

    public boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
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

        return true;
    }

    private boolean hasSpecialCharacter(String password) {
        return password.contains(SPECIAL_CHARACTERS);
    }

    private boolean hasUppercaseLetter(String password) {
        return password.matches(".*" + UPPERCASE_LETTERS + ".*");
    }

    private boolean hasLowercaseLetter(String password) {
        return password.matches(".*" + LOWERCASE_LETTERS + ".*");
    }

    private boolean hasNumber(String password) {
        return password.matches(".*" + NUMBERS + ".*");
    }
}