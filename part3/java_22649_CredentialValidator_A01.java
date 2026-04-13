public class java_22649_CredentialValidator_A01 implements CredentialValidator {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        if (credential == null || credential.getIdentifier() == null || credential.getCredential() == null) {
            throw new InvalidCredentialException("Missing username or password");
        }

        // Assuming a case-insensitive comparison
        if (credential.getIdentifier().toLowerCase().equals(VALID_USERNAME)
                && credential.getCredential().toLowerCase().equals(VALID_PASSWORD)) {
            return true;
        }

        return false;
    }
}