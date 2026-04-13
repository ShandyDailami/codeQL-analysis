public class java_24704_CredentialValidator_A03 {
    private static final Logger logger = LoggerFactory.getLogger(SecureCredentialsValidator.class);

    public boolean isValid(String userName, String password) {
        logger.info("Validating user credentials...");

        // Replace this with actual database operations or use a mock.
        // This is a mock for the purpose of this example.
        boolean isValid = userName.equals("admin") && password.equals("password");

        if (!isValid) {
            logger.warn("Invalid credentials, access denied!");
        }

        return isValid;
    }
}