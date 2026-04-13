public class java_11283_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentity().toString();
        String password = new String(credential.getCredentials());

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password.");
        }
    }
}