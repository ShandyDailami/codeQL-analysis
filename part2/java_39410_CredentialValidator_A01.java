public class java_39410_CredentialValidator_A01 implements CredentialValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomCredentialValidator.class);

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws CredentialException {
        // Ensure we have valid credentials
        if (credentials == null || credentials.getIdentifier() == null
                || credentials.getCredentials() == null) {
            LOGGER.warn("Invalid credentials: null or null identifier or credentials");
            throw new CredentialException("Invalid credentials");
        }

        // Check if the password contains at least one digit
        if (!credentials.getCredentials().toString().matches(".*[0-9].*")) {
            LOGGER.warn("Password does not contain a digit");
            throw new CredentialException("Password does not contain a digit");
        }

        // Check if the password contains at least one uppercase letter
        if (!credentials.getCredentials().toString().matches(".*[A-Z].*")) {
            LOGGER.warn("Password does not contain an uppercase letter");
            throw new CredentialException("Password does not contain an uppercase letter");
        }

        // Check if the password contains at least one lowercase letter
        if (!credentials.getCredentials().toString().matches(".*[a-z].*")) {
            LOGGER.warn("Password does not contain a lowercase letter");
            throw new CredentialException("Password does not contain a lowercase letter");
        }

        // Check if the password contains at least one special character
        if (!credentials.getCredentials().toString().matches(".*[@#$%^&*()_+\\-={}|;:,.<>?].*")) {
            LOGGER.warn("Password does not contain a special character");
            throw new CredentialException("Password does not contain a special character");
        }

        LOGGER.info("Password is valid");
        return true;
    }
}