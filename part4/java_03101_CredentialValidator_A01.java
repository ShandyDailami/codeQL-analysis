public class java_03101_CredentialValidator_A01 implements CredentialValidator {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String userName = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        if (userName.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Authentication failed: Invalid username or password");
        }
    }
}