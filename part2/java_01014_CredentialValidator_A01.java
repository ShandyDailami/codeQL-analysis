public class java_01014_CredentialValidator_A01 implements CredentialValidator {

    private static final String UPPERCASE_PATTERN = ".*[A-Z].*";
    private static final String NUMBER_PATTERN = ".*[0-9].*";
    private static final String SPECIAL_CHARACTER_PATTERN = ".*[~`!@#$%^&*()_=-].*";
    private static final String WEAK_PASSWORD_PATTERN = "^.{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) {
        String password = credentials.getPassword();

        if (!passwordMatchesPattern(password, WEAK_PASSWORD_PATTERN)) {
            return false;
        }

        if (!passwordMatchesPattern(password, UPPERCASE_PATTERN)) {
            return false;
        }

        if (!passwordMatchesPattern(password, NUMBER_PATTERN)) {
            return false;
        }

        if (!passwordMatchesPattern(password, SPECIAL_CHARACTER_PATTERN)) {
            return false;
        }

        return true;
    }

    private boolean passwordMatchesPattern(String password, String pattern) {
        return password.matches(pattern);
    }
}