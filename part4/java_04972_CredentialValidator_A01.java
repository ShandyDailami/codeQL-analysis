public class java_04972_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        // Check if the provided username and password match our expected values
        if (credential.getIdentifier().equals(USERNAME)
                && credential.getCredentials().equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}