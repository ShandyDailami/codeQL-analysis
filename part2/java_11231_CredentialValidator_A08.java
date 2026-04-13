public class java_11231_CredentialValidator_A08 {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_+`=-|[]{};':,<>?/";
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String UPPERCASE_PATTERN = "\\p{Lu}+";
    private static final String LOWERCASE_PATTERN = "\\p{Ll}+";

    public boolean isValidPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password length must be at least " + MIN_PASSWORD_LENGTH);
        }

        if (!hasSpecialCharacter(password)) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }

        if (!hasNumber(password)) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }

        if (!hasUppercaseLetter(password)) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        if (!hasLowercaseLetter(password)) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        return true;
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches("[" + SPECIAL_CHARACTERS + "]+");
    }

    private boolean hasNumber(String password) {
        return password.matches(NUMBER_PATTERN);
    }

    private boolean hasUppercaseLetter(String password) {
        return password.matches(UPPERCASE_PATTERN);
    }

    private boolean hasLowercaseLetter(String password) {
        return password.matches(LOWERCASE_PATTERN);
    }
}