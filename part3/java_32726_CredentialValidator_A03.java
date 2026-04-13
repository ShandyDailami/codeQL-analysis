public class java_32726_CredentialValidator_A03 {
    private static final String USERNAME_PATTERN = "^admin$";
    private static final String PASSWORD_PATTERN = "^password$";

    public boolean validate(String username, String password) {
        return matchesUsernamePattern(username) && matchesPasswordPattern(password);
    }

    private boolean matchesUsernamePattern(String username) {
        return username.matches(USERNAME_PATTERN);
    }

    private boolean matchesPasswordPattern(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}