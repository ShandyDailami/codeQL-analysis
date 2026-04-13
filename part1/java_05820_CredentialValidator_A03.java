public class java_05820_CredentialValidator_A03 implements CredentialValidator {
    private static final String USERNAME_PATTERN = "[a-zA-Z0-9]+";
    private static final String PASSWORD_PATTERN = "[A-Za-z0-9]{8,}";

    @Override
    public boolean validate(String username, String password) {
        return usernameMatchesPattern(username, USERNAME_PATTERN) && passwordMatchesPattern(password, PASSWORD_PATTERN);
    }

    private boolean usernameMatchesPattern(String username, String pattern) {
        return username.matches(pattern);
    }

    private boolean passwordMatchesPattern(String password, String pattern) {
        return password.matches(pattern);
    }
}