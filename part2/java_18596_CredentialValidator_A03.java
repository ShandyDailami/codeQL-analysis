public class java_18596_CredentialValidator_A03 implements CredentialValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyCredentialValidator.class);

    @Override
    public void validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String username = credential.getIdentity();
        char[] password = credential.getCredentials();

        // Step 1: Null and empty checks
        if (username == null || username.isEmpty()) {
            LOGGER.error("Invalid username provided");
            throw new InvalidCredentialException("Invalid username provided");
        }

        if (password == null || password.length == 0) {
            LOGGER.error("Invalid password provided");
            throw new InvalidCredentialException("Invalid password provided");
        }

        // Step 2: Regex check for username (Username should be alphanumeric and contain underscores)
        if (!username.matches("^[a-zA-Z0-9_]+$")) {
            LOGGER.error("Invalid username format");
            throw new InvalidCredentialException("Invalid username format");
        }

        // Step 3: Regex check for password (Password should be alphanumeric and contain special characters)
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            LOGGER.error("Invalid password format");
            throw new InvalidCredentialException("Invalid password format");
        }

        LOGGER.info("Validated credentials successfully");
    }
}