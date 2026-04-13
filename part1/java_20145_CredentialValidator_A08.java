public class java_20145_CredentialValidator_A08 implements CredentialValidator {

    private static final Logger LOGGER = Logger.getLogger(LegacyCredentialValidator.class);

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws CredentialException {
        try {
            // Simulate a security-sensitive operation
            if (credentials.getPassword().length() > 10) {
                throw new IllegalArgumentException("Password length is too long!");
            }
            // Validate username
            if (credentials.getUsername().equals("admin")) {
                throw new IllegalArgumentException("Invalid username!");
            }
            // If everything is fine, return true
            return true;
        } catch (IllegalArgumentException e) {
            // Log the error
            LOGGER.error(e.getMessage());
            // Throw a CredentialException with the error message
            throw new CredentialException(e.getMessage());
        }
    }
}