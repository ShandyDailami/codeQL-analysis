public class java_05546_CredentialValidator_A07 {

    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private static final String MEDIUM_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}$";
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$";

    public boolean isPasswordStrong(String password) {
        return passwordMatchesPattern(password, STRONG_PASSWORD_PATTERN);
    }

    public boolean isPasswordMedium(String password) {
        return passwordMatchesPattern(password, MEDIUM_PASSWORD_PATTERN);
    }

    public boolean isPasswordWeak(String password) {
        return passwordMatchesPattern(password, WEAK_PASSWORD_PATTERN);
    }

    private boolean passwordMatchesPattern(String password, String passwordPattern) {
        return password.matches(passwordPattern);
    }
}