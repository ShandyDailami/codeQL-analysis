public class java_11579_CredentialValidator_A08 {

    // The minimum length of a password.
    private static final int MIN_PASSWORD_LENGTH = 8;

    // The maximum length of a password.
    private static final int MAX_PASSWORD_LENGTH = 16;

    // The minimum length of a username.
    private static final int MIN_USERNAME_LENGTH = 3;

    // The maximum length of a username.
    private static final int MAX_USERNAME_LENGTH = 20;

    public boolean isValidUsername(String username) {
        return isValidLength(username, MIN_USERNAME_LENGTH, MAX_USERNAME_LENGTH);
    }

    public boolean isValidPassword(String password) {
        return isValidLength(password, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH)
                && containsUpperCase(password)
                && containsLowerCase(password)
                && containsDigit(password)
                && containsSpecialCharacter(password);
    }

    private boolean isValidLength(String value, int min, int max) {
        int length = value.length();
        return length >= min && length <= max;
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[~!@#$%^&*()._+`=?\\-].*");
    }
}