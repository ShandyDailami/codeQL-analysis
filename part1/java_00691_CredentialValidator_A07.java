public class java_00691_CredentialValidator_A07 implements CredentialValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCredentialValidator.class);

    @Override
    public boolean validate(String username, String password) {
        // Simulate a database lookup
        if ("admin".equals(username) && "password".equals(password)) {
            LOGGER.info("Valid user: {}", username);
            return true;
        } else {
            LOGGER.info("Invalid user: {}", username);
            return false;
        }
    }
}