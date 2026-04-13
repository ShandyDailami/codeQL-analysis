public class java_27650_CredentialValidator_A07 implements CredentialValidator {

    // Define a hard-coded data
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        // Check if the credentials are null
        if (credential == null) {
            throw new IllegalArgumentException("Credential cannot be null");
        }

        // Get the username and password from the credential
        String user = credential.getIdentifier();
        String password = credential.getPasswordAsString();

        // Validate the username and password
        if (user.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}