public class java_32978_CredentialValidator_A01 implements CredentialValidator {

    private static final Logger logger = LoggerFactory.getLogger(SimpleCredentialValidator.class);

    // Constant for minimum password strength
    private static final int MIN_PASSWORD_LENGTH = 8;

    @Override
    public boolean validate(Credential c) {
        String password = c.getPassword();
        logger.info("Validating password: " + password);

        // Check if password is null
        if (password == null) {
            logger.error("Password is null");
            return false;
        }

        // Check if password is too short
        if (password.length() < MIN_PASSWORD_LENGTH) {
            logger.error("Password length is too short. It must be at least " + MIN_PASSWORD_LENGTH + " characters long.");
            return false;
        }

        // If no errors, the password is valid
        logger.info("Password is valid.");
        return true;
    }
}