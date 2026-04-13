public class java_18017_CredentialValidator_A07 implements CredentialValidator {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String presentedPassword = credential.getPassword();
        String presentedUsername = credential.getIdentifier();

        // Validate the credentials
        if (presentedUsername.equals(USERNAME) && presentedPassword.equals(PASSWORD)) {
            return true;
        } else {
            throw new CredentialException("Invalid username or password.");
        }
    }
}