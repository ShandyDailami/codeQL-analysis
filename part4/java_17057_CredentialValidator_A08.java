public class java_17057_CredentialValidator_A08 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*=+])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) {
        return validatePassword(credentials.getUsername(), credentials.getPassword());
    }

    private boolean validatePassword(String username, String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}