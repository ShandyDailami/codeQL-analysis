public class java_23788_CredentialValidator_A07 implements CredentialValidator {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String userName = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        if (userName.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Authentication failed");
        }
    }
}