public class java_15162_CredentialValidator_A01 implements CredentialValidator {

    // This is a placeholder. In a real application, you should use a more secure method for storing usernames and passwords.
    private static final String STORED_USERNAME = "admin";
    private static final String STORED_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        // Get the input credentials
        String inputUsername = credential.getIdentifier();
        String inputPassword = new String(credential.getCredentials());

        // Check if the input credentials match the stored ones
        if (inputUsername.equals(STORED_USERNAME) && inputPassword.equals(STORED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}