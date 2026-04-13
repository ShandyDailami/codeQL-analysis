public class java_33838_CredentialValidator_A08 implements CredentialValidator {
    private static final Logger logger = Logger.getLogger(LegacyCredentialValidator.class);

    // This is just a placeholder. In reality, we'd have a mechanism to check the password strength.
    private boolean isPasswordTooShort(String password) {
        return password.length() < 8;
    }

    private boolean isPasswordTooSimple(String password) {
        return password.equals(password.toLowerCase()) || password.equals(password.toUpperCase()) || password.contains("12345678");
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String password = credential.getPassword();

        if (isPasswordTooShort(password)) {
            logger.log(Level.WARNING, "Password is too short. It must be at least 8 characters long.");
            return false;
        }

        if (isPasswordTooSimple(password)) {
            logger.log(Level.WARNING, "Password is too simple. It must contain at least one digit, one uppercase letter, and one lowercase letter.");
            return false;
        }

        logger.log(Level.INFO, "Password is valid.");
        return true;
    }
}