public class java_20783_CredentialValidator_A07 {
    // RULE: Password must have at least 8 characters
    private static final int MIN_PASSWORD_LENGTH = 8;

    // RULE: Password must contain at least one uppercase letter, one lowercase letter, and one digit
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        return true;
    }
}