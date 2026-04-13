public class java_04630_CredentialValidator_A01 implements CredentialValidator {

    private static final Logger logger = Logger.getLogger(LegacyCredentialValidator.class);

    @Override
    public boolean validate(Credential c) {
        if (c == null) {
            logger.error("Credential is null");
            return false;
        }

        // Assume the credential is a username and password
        String username = c.getUsername();
        String password = c.getPassword();

        // In a real-world scenario, this would involve a database lookup, etc.
        // For simplicity, we're just checking if the password is 'password'
        if ("password".equals(password)) {
            logger.info("Validated username: " + username);
            return true;
        } else {
            logger.error("Invalid password for username: " + username);
            return false;
        }
    }
}