public class java_20553_CredentialValidator_A08 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationFailed {
        String password = credentials.getPassword();
        if (!passwordMatchesPattern(password)) {
            throw new AuthenticationFailed("Invalid password. Password should contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
        }
        // Continue with authentication logic here
        return true;
    }

    private boolean passwordMatchesPattern(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}