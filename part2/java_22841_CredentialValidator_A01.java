public class java_22841_CredentialValidator_A01 {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password must be at least " + MIN_PASSWORD_LENGTH + " characters long");
        }

        if (!hasUpperCase(password)) {
            throw new IllegalArgumentException("Password must contain at least one upper case letter");
        }

        if (!hasLowerCase(password)) {
            throw new IllegalArgumentException("Password must contain at least one lower case letter");
        }

        if (!hasDigit(password)) {
            throw new IllegalArgumentException("Password must contain at least one digit");
        }

        if (!hasSpecialCharacter(password)) {
            throw new IllegalArgumentException("Password must contain at least one of the symbols $@#");
        }

        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.regionMatches(0, "(?=.*[A-Z])", 0, password.length());
    }

    private boolean hasLowerCase(String password) {
        return password.regionMatches(0, "(?=.*[a-z])", 0, password.length());
    }

    private boolean hasDigit(String password) {
        return password.regionMatches(0, "(?=.*[0-9])", 0, password.length());
    }

    private boolean hasSpecialCharacter(String password) {
        return password.regionMatches(0, "(?=.*[" + SPECIAL_CHARACTERS + "])", 0, password.length());
    }
}