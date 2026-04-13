public class java_13489_CredentialValidator_A01 implements CredentialValidator {
    // Constants for password length and presence of special characters
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        // Get the provided password
        String password = credentials.getPassword();

        // Check if the password is too short
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new AuthenticationFailedException("Password is too short. It must be at least " + MIN_PASSWORD_LENGTH + " characters.");
        }

        // Check if the password contains any special characters
        if (!password.matches(".*[ " + SPECIAL_CHARACTERS + "].*")) {
            throw new AuthenticationFailedException("Password must contain at least one special character. Allowed special characters are: " + SPECIAL_CHARACTERS);
        }

        // If everything is fine, return true
        return true;
    }
}