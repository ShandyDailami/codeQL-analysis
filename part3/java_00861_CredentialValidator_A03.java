public class java_00861_CredentialValidator_A03 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public boolean validate(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        if (!hasUpperCase(password)) return false;
        if (!hasLowerCase(password)) return false;
        if (!hasDigit(password)) return false;
        if (!hasSpecialCharacter(password)) return false;

        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[" + UPPERCASE_LETTERS + "].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[" + LOWERCASE_LETTERS + "].*");
    }

    private boolean hasDigit(String password) {
        return password.matches(".*[" + NUMBERS + "].*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}