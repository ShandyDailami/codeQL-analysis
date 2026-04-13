public class java_09482_CredentialValidator_A08 {

    // A pattern that matches username
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";

    // A pattern that matches password
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (!username.matches(USERNAME_PATTERN)) {
            return false;
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        return true;
    }
}